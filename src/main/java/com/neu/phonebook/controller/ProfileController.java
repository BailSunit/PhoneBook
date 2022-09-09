package com.neu.phonebook.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.neu.phonebook.dao.ContactDao;
import com.neu.phonebook.dao.UserDAO;
import com.neu.phonebook.model.User;

@Controller
public class ProfileController {

	@Autowired
	ContactDao contactDao;

	@Autowired
	UserDAO userDAO;

	@GetMapping(value = "/profile")
	public ModelAndView updateProfile(ModelMap model, User user, HttpServletRequest request) {
		HttpSession hs = request.getSession(false);
		if(hs.getAttribute("username") == null) return new ModelAndView("redirect:/");
		String username = (String) request.getSession().getAttribute("username");
		user = userDAO.get(username);
		model.addAttribute("user", user);
		String consent = user.getIsPublic().equals("true") ? "Yes" : "No";
		System.out.println(consent);
		request.setAttribute("consent", consent);
		return new ModelAndView("updateProfile");
	}

	@PostMapping(value = "/profile")
	public ModelAndView updateProfileFinal(ModelMap model, User user, HttpServletRequest request) {
		String selected = request.getParameter("consent");

		User refresh = userDAO.get((String) request.getSession().getAttribute("username"));
		refresh.setName(user.getName());
		refresh.setEmail(user.getEmail());
		refresh.setName(user.getName());
		refresh.setPhone(user.getPhone());
		refresh.setAddress(user.getAddress());
		refresh.setPassword(user.getPassword());
		if (selected.equals("truth"))
			refresh.setIsPublic("true");
		else
			refresh.setIsPublic("false");

		userDAO.update(refresh);
		request.setAttribute("user", refresh);
		String consent = refresh.getIsPublic().equals("true") ? "Yes" : "No";
		request.setAttribute("consent", consent);
		return new ModelAndView("updateProfileSuccess");
	}
}
