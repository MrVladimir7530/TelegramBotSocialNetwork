package com.example.telegrambotsocialnetwork.configurations;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Компонент отвечабщий за токен и имя бота
 */
@Data
@Configuration
@PropertySource("application.properties")
public class BotConfig {
    @Value("${bot.name}")
    private String botName;
    @Value("${bot.token}")
    private String token;

}
