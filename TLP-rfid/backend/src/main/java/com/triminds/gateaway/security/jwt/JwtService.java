package com.triminds.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;

@Service
public class JwtService {

    private final String SECRET = "super-secret-key-super-secret-key";

    private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

    public Claims parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractTenant(String token) {
        return parseToken(token).get("tenant", String.class);
    }
}