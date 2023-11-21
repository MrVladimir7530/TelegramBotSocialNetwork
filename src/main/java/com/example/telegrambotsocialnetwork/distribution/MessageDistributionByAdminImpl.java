package com.example.telegrambotsocialnetwork.distribution;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class MessageDistributionByAdminImpl implements MessageDistributionByAdmin{
    private Long chatIdUser;

    @Override
    public SendMessage distribution(Update update) {
        if (update.hasCallbackQuery()) {
            return null;
        } else if (update.getMessage().hasText()) {

        }
        return null;
    }
}
