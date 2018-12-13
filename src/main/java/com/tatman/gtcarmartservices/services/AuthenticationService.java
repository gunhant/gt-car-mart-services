package com.tatman.gtcarmartservices.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Date;

import static java.util.Collections.emptyList;

public class AuthenticationService {

    static final long EXPIRATIONTIME = 864_000_00; // 1 day in milliseconds
    static final String SIGNINGKEY = "SecretKey";
    static final String PREFIX = "Bearer";

    // add token to Authorization Header
    static public void addToken(HttpServletResponse resp, String username) {

        String JwtToken = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, SIGNINGKEY)
                .compact();

        resp.addHeader("Authorization", PREFIX + " " + JwtToken);
        resp.addHeader("Access-Control-Expose-Headers", "Authorization");
    }

    // get token from Authorization header
    static public Authentication getAuthentication(HttpServletRequest req) {

        String token = req.getHeader("Authorization");
        if(token != null) {
            String user = Jwts.parser()
                    .setSigningKey(SIGNINGKEY)
                    .parseClaimsJws(token.replace(PREFIX, ""))
                    .getBody()
                    .getSubject();

            if(user != null)
                return new UsernamePasswordAuthenticationToken(user, null, emptyList());
        }

        return null;
    }


}
