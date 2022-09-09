package com.neu.phonebook.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.phonebook.model.Contact;
import com.neu.phonebook.model.User;

public class ContactDao extends DAO {

	public ContactDao() {
	}

	public Contact get(int contactId) {
		try {
			begin();
			Query q = getSession().createQuery("from Contact where id = :contactId");
			q.setInteger("contactId", contactId);
			Contact contact = (Contact) q.uniqueResult();
			commit();
			return contact;
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Contact> getLike(String parameterValue, User user, String parameter) {
		try {
			begin();
			String regexp = "%" + parameterValue + "%";
			String hqlQuery = "from Contact where " + parameter + " like :parameterValue and user = : user";
			System.out.println(regexp);
			Query q = getSession().createQuery(hqlQuery);
			q.setString("parameterValue", regexp);
			q.setEntity("user", user);
			//q.setInteger("userId", user.getId());
			List<Contact> contactList = (ArrayList<Contact>) q.getResultList();
			commit();
			return contactList;
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
		return null;
	}

	public List<Contact> getContactList(User user) {
		try {
			begin();
			Query q = getSession().createQuery("from Contact where user.id = :user");
			q.setInteger("user", user.getId());
			List<Contact> contactList = (ArrayList<Contact>) q.getResultList();
			commit();
			return contactList;
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
		return null;
	}

	public Contact create(Contact contact) {
		try {
			begin();
			getSession().save(contact);
			commit();
			return contact;
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
		return null;
	}
	
	public void update(Contact contact) {
		try {
			begin();
			getSession().update(contact);
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
	}

	public void delete(Contact contact) {
		try {
			begin();
			getSession().delete(contact);
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
	}
}