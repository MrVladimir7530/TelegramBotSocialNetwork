package com.example.telegrambotsocialnetwork.distribution;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;


public interface MessageDistribution {
    SendMessage process(Update update);
}
