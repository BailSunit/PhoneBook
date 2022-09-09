package com.neu.phonebook.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.neu.phonebook.dao.UserDAO;
import com.neu.phonebook.model.User;

@Controller
public class UserListController {

	@Autowired
	UserDAO userDAO;

	@GetMapping(value = "/userList.htm")
	public ModelAndView userList(HttpServletRequest request) {
		HttpSession hs = request.getSession(false);
		if(hs.getAttribute("name") == null) return new ModelAndView("redirect:/");
		List<User> userList = userDAO.getUserList();
		request.setAttribute("userList", userList);
		return new ModelAndView("userList");
	}
}
