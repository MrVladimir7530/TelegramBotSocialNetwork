package com.example.telegrambotsocialnetwork.repository;

import com.example.telegrambotsocialnetwork.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

    User findByChatId(Long chatId);
}
