package com.gateway.BankAPIGateway.filter;

import java.util.*;
import java.util.function.Predicate;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class RouteValidator {
	
	public static final List<String> openApiEndpoints = List.of(
			"/user/register",
			"/user/login",
			"customer/createcustomer",
			"/eureka"
			);
	
	public Predicate<ServerHttpRequest> isSecured = 
			request -> openApiEndpoints
								.stream()
								.noneMatch(uri -> request.getURI()
														.getPath()
														.contains(uri));

}
