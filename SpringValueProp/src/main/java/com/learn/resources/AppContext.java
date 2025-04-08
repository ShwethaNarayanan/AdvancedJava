package com.learn.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import com.learn.bean.*;

@Configuration
@PropertySource("classpath:application.properties")
public class AppContext {

	// Constructor injection
	@Bean
	public Ink bInk() {
		return new BlackInk();
	}

	@Bean
	public Pen fPen(Ink ink) {
		return new FountainPen(ink);
	}

	@Bean
	public Writer writer(Pen pen) {
		return new Writer(pen);
	}

	@Bean
	public PropertySourcesPlaceholderConfigurer propertySrc() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
