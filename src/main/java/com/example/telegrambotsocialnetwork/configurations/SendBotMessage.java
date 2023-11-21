package com.example.telegrambotsocialnetwork.configurations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@Slf4j
@Configuration
public class SendBotMessage {
    private static final String ERROR = "ERROR: ";
    private static final String SUCCESSFUL_MESSAGE_SENDING = "successful message sending";
    private final TelegramBot telegramBot;

    public SendBotMessage(@Lazy final TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    public SendMessage sendMessage(Long chatId, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);
        try {
            telegramBot.execute(sendMessage);
            log.info(SUCCESSFUL_MESSAGE_SENDING);
        } catch (TelegramApiException e) {
            log.error(ERROR, e);
        }
        return sendMessage;
    }

}
