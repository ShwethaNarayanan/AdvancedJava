package com.learn.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.learn")
public class AppConfig extends WebMvcConfigurationSupport{
	//Dispatcher Servlet
	
	@Override
	protected void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	@Bean
	public InternalResourceViewResolver irViewResolver() {
		InternalResourceViewResolver irvr = new InternalResourceViewResolver();
		irvr.setPrefix("/WEB-INF/");
		irvr.setSuffix(".jsp");
		return irvr;
	}
	@Bean
	public DriverManagerDataSource myDataSource() {
		//Data Source has all the DB  connection
		DriverManagerDataSource myds = new DriverManagerDataSource();
		myds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		myds.setUrl("jdbc:mysql://localhost:3306/advjava");
		myds.setUsername("root");
		myds.setPassword("root");
		return myds;
		}
	
	@Bean
	public JdbcTemplate myjdbcTemp() {
		JdbcTemplate myJdbcTemp = new JdbcTemplate();
		myJdbcTemp.setDataSource(myDataSource());
		return myJdbcTemp;
	}
	

}
