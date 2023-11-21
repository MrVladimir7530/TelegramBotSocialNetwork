package com.example.telegrambotsocialnetwork.distribution;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class MessageDistributionByAdminImpl implements MessageDistributionByAdmin{

    @Override
    public SendMessage distribution(Update update) {
        return null;
    }
}
