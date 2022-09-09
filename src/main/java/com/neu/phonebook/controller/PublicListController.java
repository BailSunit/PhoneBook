package com.neu.phonebook.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.neu.phonebook.dao.UserDAO;
import com.neu.phonebook.model.User;

@Controller
public class PublicListController {

	@Autowired
	UserDAO userDAO;

	@GetMapping(value = "/yellowPages.htm")
	public ModelAndView yelloPages(HttpServletRequest request) {
		List<User> userList = userDAO.getUserList();
		request.setAttribute("userList", userList);
		return new ModelAndView("yellowPages");
	}
}
