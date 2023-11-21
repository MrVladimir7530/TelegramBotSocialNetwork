package com.example.telegrambotsocialnetwork.send_message;

import com.example.telegrambotsocialnetwork.configurations.SendBotMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
@RequiredArgsConstructor
public class  SendMessageFromUser {
    private final SendBotMessage sendBotMessage;

    public SendMessage sendMessage(Update update) {
        String textMessage = update.getMessage().getText();



        return sendBotMessage.sendMessage(12L, "231");
    }

}
