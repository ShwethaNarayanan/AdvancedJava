package com.apex.user.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	private static Configuration configuration;

	// Create the initial SessionFactory from the default configuration files
	static {
		try {
			configuration = new Configuration();
			sessionFactory = configuration.configure().buildSessionFactory();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
