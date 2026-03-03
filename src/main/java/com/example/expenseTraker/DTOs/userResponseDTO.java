package com.example.expenseTraker.DTOs;

import com.example.expenseTraker.model.User;
import org.springframework.stereotype.Component;

//@Component
public class userResponseDTO {
    private String username;
    private String password;

    public userResponseDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public userResponseDTO() {
    }

    @Override
    public String toString() {
        return "userResponseDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
