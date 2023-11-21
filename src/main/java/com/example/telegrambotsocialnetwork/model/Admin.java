package com.example.telegrambotsocialnetwork.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@Entity(name = "admins")
public class Admin {
    @Id
    private Long id;
    private Long companionId;
    private String stage;
    @OneToOne
    @JoinColumn(name = "admin_id")
    private User user;

}
