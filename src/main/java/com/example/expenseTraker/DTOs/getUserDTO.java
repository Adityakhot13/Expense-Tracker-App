package com.example.expenseTraker.DTOs;

public class getUserDTO {

    private Long userId;
    private String username;
    private String email;

    public getUserDTO() {
    }

    public getUserDTO(Long userId, String username, String email) {
        this.userId = userId;
        this.username = username;
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "getUserDTO{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
