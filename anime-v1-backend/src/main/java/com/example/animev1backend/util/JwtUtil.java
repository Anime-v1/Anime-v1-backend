package com.example.animev1backend.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private String secret = "5a77cc5e6fcb301cfccd4e576da644d62ce13c66b0eaf7b8c7f07d39339ebc8ec483f2eaf1502075edfe1ae4167f7bea3d10a1d7dd28c86791377ed3d4ecfb1204a6123d01f8724c1a38b0cb80a14c9103c17107a4b7901b09a5db412ecdbe7925cd1f12c6f79ab8b01e8a87725c2ef8e267bb57beb601f0c742a06b5cccc8aba0b04263913f0d1c3fba317e1961f7c7426d9ebf2ece27312025d7d79e763a817affdada64eb4cd2dcac9c53432c6370607aeb4093f7c1a21635f333e768125598d8f074f58a73c8f95244411f0aa0043b2d5f81d12326bd8508b07895bd0c8f797c1f2bf4b67c2401e914ad9f04789a1001aa8f13e98e97780f3636c6dc035c";

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        Date expiration = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
        return expiration.before(new Date());
    }
}
