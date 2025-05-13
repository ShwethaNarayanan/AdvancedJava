package com.learn.resources;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.ServletRegistration.Dynamic;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;

public class WebConfig implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		//Create an application context for the Dispatcher Servlet and register the Dispatcher Config class to the context
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(AppConfig.class);
		
		Dynamic disp = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
		disp.setLoadOnStartup(1);
		disp.addMapping("/");
	}

}
