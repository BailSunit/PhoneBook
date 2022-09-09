package com.neu.phonebook.controller;

import java.util.List;

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
public class UpdateContactController {

	@Autowired
	ContactDao contactDao;

	@Autowired
	UserDAO userDAO;

	@GetMapping(value = "/update.htm")
	public ModelAndView updateContact(HttpServletRequest request) {
		HttpSession hs = request.getSession(false);
		if(hs.getAttribute("username") == null) return new ModelAndView("redirect:/");
		String username = (String) request.getSession().getAttribute("username");
		User user = userDAO.get(username);
		List<Contact> contacts = contactDao.getContactList(user);
		request.setAttribute("contactList", contacts);
		return new ModelAndView("update");
	}

	@PostMapping(value = "/update.htm")
	public ModelAndView updateContactSpecific(ModelMap model, @ModelAttribute("contact")Contact contact, HttpServletRequest request) {
		String source = request.getParameter("source");

		if (source.equals("firstForm")) {
			String contactId = request.getParameter("contact");
			Contact con = contactDao.get(Integer.parseInt(contactId));
			contact = con;
			model.addAttribute("contact", contact);
			return new ModelAndView("updateContact");
		} else if (source.equals("finalForm")) {
			Contact refresh = contactDao.get(contact.getId());
			refresh.setName(contact.getName());
			refresh.setPhone(contact.getPhone());
			refresh.setAddress(contact.getAddress());
			refresh.setId(Integer.parseInt(request.getParameter("id")));
			contactDao.update(refresh);
			request.setAttribute("contact", refresh);
			return new ModelAndView("updateSuccess");
		}
		return new ModelAndView("login");

	}
}
