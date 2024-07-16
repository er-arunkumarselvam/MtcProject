package com.example.demo.webToken;

import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service	
public class JwtServices {
	private final String secretKey = "89AEFD6F01682DB88C01566B083EFC3770FB03055CF5EB0B34727EC9BC72CBD13BDAD8ADD3D5B9D0A39C3D2CCE53053C773ADE2E309A8AF320CA0260D113E6F8";
	private final long keyValidity = TimeUnit.MINUTES.toMillis(30);
	
	public String generateToken(UserDetails myUserObj)
	{
		return Jwts.builder()
				.subject((myUserObj).getUsername())
				.issuedAt(Date.from(Instant.now()))
				.expiration(Date.from(Instant.now().plusMillis(keyValidity)))
				.signWith(generateKey())
				.compact();
	}
	
	private SecretKey generateKey()
	{
		byte[] byteKey = Base64.getDecoder().decode(secretKey);
		return Keys.hmacShaKeyFor(byteKey);
	}

    public String extractUsername(String jwt) {
        Claims claims = getClaims(jwt);
        return claims.getSubject();
    }

    private Claims getClaims(String jwt) {
        return Jwts.parser()
                 .verifyWith(generateKey())
                 .build()
                 .parseSignedClaims(jwt)
                 .getPayload();
    }

    public boolean isTokenValid(String jwt) {
        Claims claims = getClaims(jwt);
        return claims.getExpiration().after(Date.from(Instant.now()));
    }
}

