package com.jwt.springsecurity.model;

import lombok.*;


public class JWTRequest {
    private String username;

    public String getPassword() {
        return password;
    }

    public JWTRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String password;
}
