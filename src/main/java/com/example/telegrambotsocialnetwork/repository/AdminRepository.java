package com.example.telegrambotsocialnetwork.repository;

import com.example.telegrambotsocialnetwork.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    @Query(value = "SELECT companion_id from admins AS ad " +
            "INNER JOIN users AS us ON us.chat_id = ad.admin_id " +
            "WHERE us.chat_id = ?1 ", nativeQuery = true)
    Long findCompanionIdByChatId(Long chatId);
}
