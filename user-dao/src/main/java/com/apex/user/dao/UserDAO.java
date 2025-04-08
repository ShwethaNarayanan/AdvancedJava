package com.apex.user.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.apex.user.util.HibernateUtil;
import com.apex.user.vo.User;

@Repository
public class UserDAO {

	public void addUser(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		System.out.println(user.getFirstName());
		session.save(user);
		tx.commit();
	}

	public void updateUser(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.update(user);
		tx.commit();
	}

	public User getUser(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		User user = (User) session.load(com.apex.user.vo.User.class, new Integer(id));
		return user;
	}

	public void deleteUser(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		User user = (User) session.load(com.apex.user.vo.User.class, new Integer(id));
		Transaction tx = session.beginTransaction();
		session.delete(user);
		tx.commit();
	}

}
