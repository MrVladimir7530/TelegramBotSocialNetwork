package com.example.telegrambotsocialnetwork.configurations;

import com.example.telegrambotsocialnetwork.distribution.MessageDistribution;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;


@Slf4j
@RequiredArgsConstructor
@Configuration
public class TelegramBot extends TelegramLongPollingBot {
    private final BotConfig botConfig;
    private final MessageDistribution messageDistribution;

    @Override
    public void onUpdateReceived(Update update) {
        messageDistribution.process(update);
    }

    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }
    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }
}
