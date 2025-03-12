package com.user.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.user.service.CustomUserDetailService;
import com.user.utils.JWTAuthEntryPoint;
import com.user.utils.JwtFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private CustomUserDetailService customUserDetailService;
	private JWTAuthEntryPoint jwtAuthEnrtyPoint;
	private JwtFilter jwtFilter;
	
	@Autowired
	public SecurityConfig(CustomUserDetailService customUserDetailService, JWTAuthEntryPoint jwtAuthEntryPoint,
							JwtFilter jwtFilter) {
		this.customUserDetailService = customUserDetailService;
		this.jwtAuthEnrtyPoint = jwtAuthEntryPoint;
		this.jwtFilter = jwtFilter;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf(customizer -> customizer.disable())
					.exceptionHandling(customizer -> customizer.authenticationEntryPoint(jwtAuthEnrtyPoint))
					.authorizeHttpRequests(request -> request
							.requestMatchers("/user/register","/user/login").permitAll()
							.anyRequest().authenticated())
					.formLogin(Customizer.withDefaults())
					.httpBasic(Customizer.withDefaults())
					.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
					.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		return httpSecurity.build();
		
	}
	
	@Bean
	public AuthenticationManager getAuthenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	@Bean
	public AuthenticationProvider getAuthenticationProvider() {
		DaoAuthenticationProvider daoAuthProvider = new DaoAuthenticationProvider();
		// Set the Password Encoder to encrypt the password before saving to the DB
		daoAuthProvider.setPasswordEncoder(getPasswordEncoder());
		// Set the CustomUserDetailsService to interact with the DB
		daoAuthProvider.setUserDetailsService(customUserDetailService);		
		
		return daoAuthProvider;
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
