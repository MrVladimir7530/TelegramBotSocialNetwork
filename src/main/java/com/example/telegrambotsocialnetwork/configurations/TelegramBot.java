package com.example.telegrambotsocialnetwork.configurations;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;


@Slf4j
@RequiredArgsConstructor
public class TelegramBot extends TelegramLongPollingBot {
    private final BotConfig botConfig;

    @Override
    public void onUpdateReceived(Update update) {

    }

    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }
}
