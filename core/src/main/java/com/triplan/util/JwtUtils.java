package com.triplan.util;

import com.triplan.security.MemberDetailsService;
import com.triplan.security.MemberPrincipal;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.util.Date;

@Component
public final class JwtUtils {

    public static final String BEARER_PREFIX = "Bearer ";

    private final String secretKey;
    private final int expirationInMs;

    private final Key key;

    private final MemberDetailsService memberDetailsService;

    public JwtUtils(
            @Value("${app.jwt.secretKey}") String secretKey,
            @Value("${app.jwt.expirationInMs}") int expirationInMs,
            MemberDetailsService memberDetailsService)
    {
        this.memberDetailsService = memberDetailsService;
        this.secretKey = secretKey;
        this.expirationInMs = expirationInMs;
        key = Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public String generateToken(Authentication auth) {
        MemberPrincipal memberPrincipal = (MemberPrincipal) auth.getPrincipal();
        String memberId = String.valueOf(memberPrincipal.getMemberId());

        Date now = new Date();
        Date expiration = new Date(now.getTime() + expirationInMs);

        return Jwts.builder()
                .setSubject(memberId)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(key)
                .compact();
    }

    public String getTokenFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(BEARER_PREFIX)) {
            return bearerToken.substring(BEARER_PREFIX.length());
        }

        return null;
    }

    public boolean verify(String jwt) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(jwt)
                    .getBody();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public UsernamePasswordAuthenticationToken getAuthFromJWT(String jwt) {
        Integer id = getUserIdFromJWT(jwt);
        UserDetails userDetails = memberDetailsService.loadUserById(id);

        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }

    public Integer getUserIdFromJWT(String jwt) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jwt)
                .getBody();

        return Integer.parseInt(claims.getSubject());
    }
}
