package com.neu.phonebook.controller;

import java.util.ArrayList;
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
public class SearchContactController {

	@Autowired
	ContactDao contactDao;
	
	@Autowired
	UserDAO userDAO;

	@GetMapping(value = "/searchContact.htm")
	public ModelAndView searchContact(HttpServletRequest request) {
		HttpSession hs = request.getSession(false);
		if(hs.getAttribute("username") == null) return new ModelAndView("redirect:/");
		return new ModelAndView("searchContact");
	}

	@PostMapping(value = "/searchContact.htm")
	public ModelAndView searchContactResult(HttpServletRequest request) {
		String contactname = (String) request.getParameter("keyword");
        String parameter = request.getParameter("parameter");
		User user = userDAO.get((String)request.getSession().getAttribute("username"));
		List<Contact> contactList = (ArrayList<Contact>)contactDao.getLike(contactname, user,parameter);
		if(contactList.isEmpty()) {
			request.setAttribute("contactname", contactname);
			return new ModelAndView("searchResultsEmpty");
		}
		else {
			request.setAttribute("contactList", contactList);
			return new ModelAndView("searchResults");
		}
	}

}
