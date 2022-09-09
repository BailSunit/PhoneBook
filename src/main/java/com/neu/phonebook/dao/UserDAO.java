package com.neu.phonebook.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.phonebook.model.Contact;
import com.neu.phonebook.model.User;

public class UserDAO extends DAO {

	public UserDAO() {
	}

	public User get(String username) {
		try {
			begin();
			Query q = getSession().createQuery("from User where username = :username");
			q.setString("username", username);
			User user = (User) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
		return null;
	}
	
	public User get(int id) {
		try {
			begin();
			Query q = getSession().createQuery("from User where id = :id");
			q.setInteger("id", id);
			User user = (User) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
		return null;
	}
	
	public List<User> get() {
		try {
			begin();
			Query q = getSession().createQuery("from User");
			List<User> userList = (ArrayList<User>) q.getResultList();
			commit();
			return userList;
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
		return null;
	}
	
	public List<User> getUserList() {
		try {
			begin();
			Query q = getSession().createQuery("from User where isPublic = :public");
			q.setString("public", "true");
			List<User> userList = (ArrayList<User>) q.getResultList();
			System.out.println(userList);
			commit();
			return userList;
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
		return null;
	}

	public User create(User user) {
		try {
			begin();
			getSession().save(user);
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
			throw e;
		}
	}
	
	public void update(User user) {
		try {
			begin();
			getSession().update(user);
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
	}

	public void delete(User user) {
		try {
			begin();
			getSession().delete(user);
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
	}
}