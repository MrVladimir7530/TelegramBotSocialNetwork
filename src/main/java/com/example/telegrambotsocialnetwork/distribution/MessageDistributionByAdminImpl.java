package com.example.telegrambotsocialnetwork.distribution;

import com.example.telegrambotsocialnetwork.configurations.SendBotMessage;
import com.example.telegrambotsocialnetwork.model.User;
import com.example.telegrambotsocialnetwork.repository.AdminRepository;
import com.example.telegrambotsocialnetwork.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;


@Service
@RequiredArgsConstructor
public class MessageDistributionByAdminImpl implements MessageDistributionByAdmin{
    private final SendBotMessage sendBotMessage;
    private final AdminRepository adminRepository;
    private final UsersRepository usersRepository;

    @Override
    public SendMessage distribution(Update update) {
        if (update.hasCallbackQuery()) {
            return null;
        } else if (update.getMessage().hasText()) {
            Long chatId = update.getMessage().getChatId();
            Long companionId = adminRepository.findCompanionIdByChatId(chatId);
            String textMessage = update.getMessage().getText();
            textMessage = getUserNameOrFirstName(companionId) + ": " + textMessage;
            sendBotMessage.sendMessage(companionId, textMessage);
        }
        return null;
    }

    private String getUserNameOrFirstName(Long companionId) {
        User user = usersRepository.findByChatId(companionId);
        String userName = user.getUserName();
        if (userName != null) {
            return userName;
        }
        return user.getFirstName();
    }
}
