package com.neu.phonebook.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.neu.phonebook.dao.ContactDao;
import com.neu.phonebook.dao.UserDAO;
import com.neu.phonebook.model.Contact;
import com.neu.phonebook.model.User;

@Controller
public class DeleteUserController {

	@Autowired
	ContactDao contactDao;

	@Autowired
	UserDAO userDAO;

	@GetMapping(value = "deleteUser.htm")
	public ModelAndView deleteContact(HttpServletRequest request) {
		HttpSession hs = request.getSession(false);
		if(hs.getAttribute("name") == null) return new ModelAndView("redirect:/admin");
		List<User> users = userDAO.get();
		request.setAttribute("userList", users);
		return new ModelAndView("deleteUser");
	}

	@PostMapping(value = "deleteUser.htm")
	public ModelAndView deleteContactSpecific(HttpServletRequest request) {
		String userId = request.getParameter("user");
		User user = userDAO.get(Integer.parseInt(userId));
		List<Contact> contacts = contactDao.getContactList(user);
		for(Contact contact : contacts) {
			contactDao.delete(contact);
		}
		userDAO.delete(user);
		return new ModelAndView("deleteUserSuccess");
	}
}
