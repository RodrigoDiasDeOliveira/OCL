package com.triminds.security.auth;

public class TokenResponse {

    private String token;

    public TokenResponse() {}

    public TokenResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}