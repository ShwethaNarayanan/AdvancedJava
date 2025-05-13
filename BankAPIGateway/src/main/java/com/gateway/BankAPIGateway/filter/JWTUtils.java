package com.gateway.BankAPIGateway.filter;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTUtils {
	
	private String secretKey = "";
	

	public JWTUtils() {

		try {
			KeyGenerator keyGen = KeyGenerator.getInstance("HMACSHA256");
			SecretKey sk = keyGen.generateKey();
			secretKey = Base64.getEncoder().encodeToString(sk.getEncoded());

		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e.getMessage());
		}

	}

	private SecretKey getSecretKey() {
		byte[] byteKey = Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(byteKey);
	}

	

	public String validateToken(String token) {
		String userName = getUsernameFromToken(token);
		if(!isTokenExpired(token))
			return  userName;	
		else
			return "Not authenticated!";
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
