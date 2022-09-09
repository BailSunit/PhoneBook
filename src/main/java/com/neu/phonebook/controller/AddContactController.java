package com.neu.phonebook.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.neu.phonebook.dao.ContactDao;
import com.neu.phonebook.dao.UserDAO;
import com.neu.phonebook.model.Contact;
import com.neu.phonebook.model.User;

@Controller
public class AddContactController {

	@Autowired
	ContactDao contactDao;
	
	@Autowired
	UserDAO userDAO;

	@GetMapping(value = "/addContact.htm")
	public ModelAndView addContact(ModelMap model, Contact contact, HttpServletRequest request) {
		HttpSession hs = request.getSession(false);
		if(hs.getAttribute("username") == null) return new ModelAndView("redirect:/");
		model.addAttribute("contact", contact);// Command Class
		return new ModelAndView("addContact");
	}

	@PostMapping(value = "/addContact.htm")
	public ModelAndView addContact(@ModelAttribute("contact") Contact contact, HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("username");
		System.out.println("Username" + username);
		User user = userDAO.get(username);
		contact.setUser(user);
		Contact committed = contactDao.create(contact);

		if (committed != null)
			return new ModelAndView("addContactSuccess");

		else {
			return new ModelAndView("addContactError");
		}
	}

}
