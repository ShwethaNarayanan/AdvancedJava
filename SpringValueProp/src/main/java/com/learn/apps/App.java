package com.learn.apps;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.learn.bean.Writer;
import com.learn.resources.AppContext;


public class App {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
    	Writer writer = (Writer) context.getBean("writer");
        writer.write();
	}

}
