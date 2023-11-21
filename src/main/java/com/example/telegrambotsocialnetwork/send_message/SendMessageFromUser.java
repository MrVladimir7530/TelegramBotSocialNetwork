package com.example.telegrambotsocialnetwork.send_message;

import com.example.telegrambotsocialnetwork.configurations.SendBotMessage;
import com.example.telegrambotsocialnetwork.model.User;
import com.example.telegrambotsocialnetwork.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
@RequiredArgsConstructor
public class  SendMessageFromUser {
    private final SendBotMessage sendBotMessage;
    private final UsersRepository usersRepository;

    public SendMessage sendMessage(Update update, Long chatIdAdmin) {
        Long chatId = update.getMessage().getChatId();

        User user = usersRepository.findByChatId(chatId);
        if (user == null) {
            createNewUser(update);
        }

        String textMessage = update.getMessage().getText();
        return sendBotMessage.sendMessage(chatIdAdmin, textMessage);
    }
    private User createNewUser(Update update) {
        User users = new User();

        Long chatId = update.getMessage().getChatId();
        String firstName = update.getMessage().getChat().getFirstName();
        String lastName = update.getMessage().getChat().getLastName();
        String userName = update.getMessage().getChat().getUserName();

        users.setChatId(chatId);
        users.setFirstName(firstName);
        users.setLastName(lastName);
        users.setUserName(userName);
        return users;
    }

}
