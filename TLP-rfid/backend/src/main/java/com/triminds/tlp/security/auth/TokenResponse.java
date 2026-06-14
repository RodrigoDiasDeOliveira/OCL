package com.triminds.tlp.security.auth;

public record TokenResponse(String accessToken, String tokenType, long expiresIn) {
    public static TokenResponse bearer(String token, long expiresIn) {
        return new TokenResponse(token, "Bearer", expiresIn);
    }
}
