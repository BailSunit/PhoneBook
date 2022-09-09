package com.neu.phonebook.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.neu.phonebook.model.User;

@Controller
@SessionAttributes("admin")
public class AdminController {

	@GetMapping(value = "/admin")
	public String showForm(ModelMap model, User user, HttpServletRequest request) {
		request.getSession().invalidate();
		user.setUsername("admin");
		user.setPassword("admin");
		model.addAttribute("user", user);
		return "admin";

	}

	@GetMapping(value = "/adminDashboard")
	public String showDashboard(HttpServletRequest request) {
		if (request.getSession(false) != null)
			return "dashboard";
		else {
			return "admin";
		}
	}

	@PostMapping(value = "/admin")
	public String showSuccess(@ModelAttribute("user") User user, HttpServletRequest request) {
		if (user.getUsername().equals("bailsunit.admin") && user.getPassword().equals("password")) {
			HttpSession hs = request.getSession();
			hs.setAttribute("name", "Sunit");
			return "dashboard";
		}

		else {
			return "invalid";
		}

	}
}
