package com.neu.phonebook.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.neu.phonebook.dao.UserDAO;
import com.neu.phonebook.model.User;

@Controller
public class RegisterController {

	@Autowired
	UserDAO userDAO;

	@GetMapping(value = "/register.htm")
	public ModelAndView addUser(ModelMap model, User user, HttpServletRequest request) {
		model.addAttribute("user", user);// Command Class
		return new ModelAndView("register");
	}

	@PostMapping(value = "/register.htm")
	public ModelAndView addUser(@ModelAttribute("user") User user, HttpServletRequest request) {
		String selected = request.getParameter("consent");

		try {
			if (selected.equals("truth"))
				user.setIsPublic("true");
			else
				user.setIsPublic("false");
			User committed = userDAO.create(user);
			if (committed != null && committed.getPassword().equals(user.getPassword())) {
				HttpSession hs = request.getSession();
				String[] fullName = committed.getName().split(" ");
				hs.setAttribute("name", fullName[0]);
				hs.setAttribute("username", committed.getUsername());
				return new ModelAndView("login");
			} else {
				return new ModelAndView("registrationError");
			}

		} catch (ConstraintViolationException e) {
			return new ModelAndView("usernameError");
		}
	}

}
