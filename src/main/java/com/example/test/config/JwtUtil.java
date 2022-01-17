package com.example.test.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import java.util.Collections;

public class JwtUtil {
    // Metodo para crear el JSON WEB TOKEN y enviarlo al cliente en el header de la respuesta
    static void addAuthentication(HttpServletResponse response, String idCard) {
        String token = Jwts.builder().setSubject(idCard).signWith(SignatureAlgorithm.HS512, "Test").compact();
        response.addHeader("Authorization", "Bearer" + token);
    }

    static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null) {
            String client = Jwts.parser().setSigningKey("Test").parseClaimsJws(token.replace("Bearer", "")).getBody().getSubject();
            if (client != null) {
                return new UsernamePasswordAuthenticationToken(client, null, Collections.emptyList());
            } else
                return null;
        }
       return null;
    }

}
