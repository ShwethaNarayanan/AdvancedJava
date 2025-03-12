package com.user.utils;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.user.service.CustomUserDetailService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

	private JWTService jwtService;
	private CustomUserDetailService customUserDetailService;

	@Autowired
	public JwtFilter(JWTService jwtService, CustomUserDetailService customUserDetailService) {
		this.jwtService = jwtService;
		this.customUserDetailService = customUserDetailService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String username = null;
		String jwtToken = getJwtTokenFromRequest(request);
		if (jwtToken != null) {
			username = jwtService.getUsernameFromToken(jwtToken);
		}
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = customUserDetailService.loadUserByUsername(username);
			if (jwtService.validateToken(jwtToken, userDetails, username)) {
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
						null, userDetails.getAuthorities());
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				// It's important to store the authentication Token in Security Context
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}
		filterChain.doFilter(request, response);

	}

	private String getJwtTokenFromRequest(HttpServletRequest request) {

		String bearer_token = request.getHeader("Authorization");
		if (bearer_token != null && bearer_token.startsWith("Bearer ")) {
			return bearer_token.substring(7);
		}
		return null;
	}

}
