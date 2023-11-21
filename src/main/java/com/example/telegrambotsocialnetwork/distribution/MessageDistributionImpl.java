package com.example.telegrambotsocialnetwork.distribution;

import com.example.telegrambotsocialnetwork.send_message.SendMessageFromUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
@RequiredArgsConstructor
public class MessageDistributionImpl implements MessageDistribution {
    private final MessageDistributionByAdmin messageDistributionByAdmin;
    private final SendMessageFromUser sendMessageFromUser;


    @Override
    public SendMessage process(Update update) {
        Long chatId = update.getMessage().getChatId();
        if (chatId == 1L) {
            return messageDistributionByAdmin.distribution(update);
        }
        return sendMessageFromUser.sendMessage(update, 1318507437L);
    }
}
