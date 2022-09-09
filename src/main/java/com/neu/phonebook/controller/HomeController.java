package com.neu.phonebook.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.neu.phonebook.dao.UserDAO;
import com.neu.phonebook.model.User;

@Controller
@SessionAttributes("login")
public class HomeController {

	@Autowired
	UserDAO userDAO;

	@GetMapping(value = "/")
	public String showForm(ModelMap model, User user, HttpServletRequest request) {
		request.getSession().invalidate();
		user.setUsername("Username");
		user.setPassword("password");
		model.addAttribute("user", user);// Command Class
		return "home";

	}

	@GetMapping(value = "/dashboard")
	public String showDashboard(HttpServletRequest request) {
		if (request.getSession(false) != null)
			return "login";
		else {
			return "home";
		}
	}

	@PostMapping(value = "/")
	public String showSuccess(@ModelAttribute("user") User user, HttpServletRequest request) {
		User committed = userDAO.get(user.getUsername());

		if (committed != null && committed.getPassword().equals(user.getPassword())) {
			HttpSession hs = request.getSession();
			String[] fullName = committed.getName().split(" ");
			hs.setAttribute("name", fullName[0]);
			hs.setAttribute("username", committed.getUsername());
			return "login";
		}

		else {
			return "invalid";
		}

	}
}
