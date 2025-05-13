package com.user.utils;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.user.exceptions.CustomExceptions;
import com.user.service.CustomUserDetailService;

import java.util.HashMap;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {

	private String secretKey = "";
	

	public JWTService() {

		try {
			KeyGenerator keyGen = KeyGenerator.getInstance("HMACSHA256");
			SecretKey sk = keyGen.generateKey();
			secretKey = Base64.getEncoder().encodeToString(sk.getEncoded());

		} catch (NoSuchAlgorithmException e) {
			throw new CustomExceptions(HttpStatus.BAD_REQUEST, e.getMessage());
		}

	}

	private SecretKey getSecretKey() {
		byte[] byteKey = Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(byteKey);
	}

	public String generateToken(Authentication authentication) {
		// Claims - stores the details about the user in key-value pair format.
		// Key - String and Value can be any object like date, string etc. We are
		// building claims using Jwts builder

		Map<String, Object> claims = new HashMap<>();

		return Jwts.builder().claims().add(claims).subject(authentication.getName())
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + 60 * 60 * 30)).and().signWith(getSecretKey())
				.compact();

	}

	public boolean validateToken(String token, UserDetails userDetails, String username) {
		// Check if the user name matches with the user name stored in the DB and if the 
		// token has not expired
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token)) ;		
	}
	
	public Claims getClaimsFromToken(String token) {
		// Extract claim from token using the secretKey
		return Jwts.parser()
				   .verifyWith(getSecretKey())
				   .build()
				   .parseSignedClaims(token)
				   .getPayload();
	}

	public String getUsernameFromToken(String token) {
		Claims claims  = getClaimsFromToken(token);
		return claims.getSubject();
	}

	public Date getExpirationFromToken(String token) {
		Claims claims  = getClaimsFromToken(token);
		return claims.getExpiration();
	}
	
	public boolean isTokenExpired(String token) {
        return getExpirationFromToken(token).before(new Date());
    }
}
