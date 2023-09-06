package com.example.api.util;

import com.example.api.entities.User;
import com.example.api.exceptions.UnauthorizedException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
import java.util.function.Supplier;

@Service
public class JwtTokenUtil {
    private static SecretKey secretKey;

    public JwtTokenUtil() {
        fetchSecretKey();
    }

    public static String generateToken(String userId, String username, String role) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + 3600000); //token valid for 1 hour

        return Jwts.builder()
                .setSubject(userId)
                .claim("email", username)
                .claim("role", role)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(secretKey)
                .compact();
    }

    public static boolean isValidToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static TokenEmail extractTokenEmailInfo(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            String email = (String) claims.get("email");
            return new TokenEmail(email);
        } catch (Exception e) {
            throw new UnauthorizedException("Invalid token; access denied.");
        }
    }

    public static TokenRole extractTokenRoleInfo(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            String role = (String) claims.get("role");
            return new TokenRole(role);
        } catch (Exception e) {
            throw new UnauthorizedException("Invalid token; access denied.");
        }
    }

    public static void handleVoidAdminMethodAccess(String token, Runnable method) {
        if (isAdmin(token)) {
            handleVoidMethodAccess(token, method);
        } else {
            throw new UnauthorizedException("Invalid admin token; access denied.");
        }
    }

    public static boolean isAdmin(String token) {
        TokenRole tokenRole = extractTokenRoleInfo(token);
        String userRole = tokenRole.role();
        return userRole.equals("ADMIN");
    }

    public static boolean isMatchingToken(String token, User user) {
        String tokenEmail = extractTokenEmailInfo(token).email();
        String tokenRole = extractTokenRoleInfo(token).role();

        if (tokenEmail.equals(user.getEmail()) &&
                tokenRole.equals(user.getUserRole().toString())) {
            return true;
        } else return false;
    }

    public static void handleVoidMethodAccess(String token, Runnable method) {
        if (JwtTokenUtil.isValidToken(token)) {
            method.run();
        } else {
            throw new UnauthorizedException("Invalid token; access denied.");
        }
    }

    public static <T> T handleReturnMethodAccess(String token, Supplier<T> method) {
        if (JwtTokenUtil.isValidToken(token)) {
            return method.get();
        } else {
            throw new UnauthorizedException("Invalid token; access denied.");
        }
    }

    public static void fetchSecretKey() {
        try {
            ClassPathResource resource = new ClassPathResource("secret_key.env");
            InputStream inputStream = resource.getInputStream();

            Properties properties = new Properties();
            properties.load(inputStream);

            secretKey = Keys.hmacShaKeyFor(properties.getProperty("JWT_SECRET_KEY").getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}