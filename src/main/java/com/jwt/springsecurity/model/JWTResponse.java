package com.jwt.springsecurity.model;

import lombok.*;

public class JWTResponse {
    private String jwtToken;

    public String getUsername() {
        return username;
    }

    public JWTResponse(String jwtToken, String username) {
        this.jwtToken = jwtToken;
        this.username = username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    private String username;
}
