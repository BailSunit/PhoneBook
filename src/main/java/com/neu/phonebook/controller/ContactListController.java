package com.neu.phonebook.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.neu.phonebook.dao.ContactDao;
import com.neu.phonebook.dao.UserDAO;
import com.neu.phonebook.model.Contact;
import com.neu.phonebook.model.User;

@Controller
public class ContactListController {

	@Autowired
	UserDAO userDAO;

	@Autowired
	ContactDao contactDao;

	@GetMapping(value = "/contactList.htm")
	public ModelAndView contactList(HttpServletRequest request) {
		HttpSession hs = request.getSession(false);
		if(hs.getAttribute("username") == null) return new ModelAndView("redirect:/");
		String username = (String) request.getSession().getAttribute("username");
		User user = userDAO.get(username);
		List<Contact> contacts = contactDao.getContactList(user);
		request.setAttribute("contactList", contacts);
		return new ModelAndView("contactList");
	}
}
