package com.example.telegrambotsocialnetwork.distribution;

import com.example.telegrambotsocialnetwork.configurations.SendBotMessage;
import com.example.telegrambotsocialnetwork.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageDistributionByAdminImpl implements MessageDistributionByAdmin{
    private final SendBotMessage sendBotMessage;
    private final AdminRepository adminRepository;

    @Override
    public SendMessage distribution(Update update) {
        if (update.hasCallbackQuery()) {
            return null;
        } else if (update.getMessage().hasText()) {
            Long chatId = update.getMessage().getChatId();
            Long companionId = adminRepository.findCompanionIdByChatId(chatId);
            String textMessage = update.getMessage().getText();
            sendBotMessage.sendMessage(companionId, textMessage);
        }
        return null;
    }
}
