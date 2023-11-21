package com.example.telegrambotsocialnetwork.service;

import com.example.telegrambotsocialnetwork.model.User;
import com.example.telegrambotsocialnetwork.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;

    public User saveUsers(User user) {
        log.info("successful user save");
        return usersRepository.save(user);
    }
}
