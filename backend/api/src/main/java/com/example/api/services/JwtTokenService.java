package com.example.api.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

@Service
public class JwtTokenService {
    private String secretKey;

    public JwtTokenService() {
        getSecretKey();
    }

    public String generateToken(String userId, String username, String role) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + 3600000); //token valid for 1 hour

        return Jwts.builder()
                .setSubject(userId)
                .claim("username", username)
                .claim("role", role)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void getSecretKey() {
        try {
            ClassPathResource resource = new ClassPathResource("secretKey.env");
            InputStream inputStream = resource.getInputStream();

            Properties properties = new Properties();
            properties.load(inputStream);

            secretKey = properties.getProperty("JWT_SECRET_KEY");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}