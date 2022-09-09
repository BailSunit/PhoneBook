package com.neu.phonebook.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {

	@GetMapping(value = "/logout.htm")
	public ModelAndView userList(HttpServletRequest request) {
		request.getSession().invalidate();
		return new ModelAndView("logout");
	}
}
