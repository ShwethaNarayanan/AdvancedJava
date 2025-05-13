package com.gateway.BankAPIGateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

	@Autowired
	private RouteValidator routeValidator;

	@Autowired
	private JWTUtils jwtUtils;

	public AuthenticationFilter() {
		super(Config.class);
	}

	public static class Config {
	}

	@Override
	public GatewayFilter apply(Config config) {
		return ((exchange, chain) -> {
			if (routeValidator.isSecured.test(exchange.getRequest())) {
				// Check if the header has the Authorization token
				if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
					throw new RuntimeException("Missing the Authorization header!");
				}
				// If the request contains the Authorization token, get the token
				String authorizationHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

				if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
					String token = authorizationHeader.substring(7);
					String username = jwtUtils.validateToken(token);

					return chain.filter(exchange.mutate()
							.request(exchange.getRequest().mutate().header("X-Username", username).build()).build());
				}

			}
			return chain.filter(exchange);
		});
	}
}
