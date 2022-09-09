package com.neu.phonebook.controller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.neu.phonebook.dao.ContactDao;
import com.neu.phonebook.dao.UserDAO;
import com.neu.phonebook.model.Contact;
import com.neu.phonebook.model.User;
import com.opencsv.CSVReader;

@Controller
public class UploadContactListController {

	@Autowired
	UserDAO userDAO;

	@Autowired
	ContactDao contactDao;

	@GetMapping(value = "/upload")
	public ModelAndView downloadContactList(HttpServletRequest request) {
		HttpSession hs = request.getSession(false);
		if(hs.getAttribute("username") == null) return new ModelAndView("redirect:/");
		String username = (String) request.getSession().getAttribute("username");
		User user = userDAO.get(username);
		List<Contact> contacts = readContactsFile();
		if(contacts==null) return new ModelAndView("fileUploadError");
		for(Contact contact : contacts) {
			contact.setUser(user);
			contactDao.create(contact);		
			}
		return new ModelAndView("redirect:/contactList.htm");
	}

	private List<Contact> readContactsFile() {

		File file = new File("/Users/sunitbail/Downloads/contacts/contacts.csv");
		List<Contact> contacts = new ArrayList<Contact>();
		Contact contact;
		if(!file.exists()) return null;
		try {
			FileReader outputfile = new FileReader(file);
			CSVReader reader = new CSVReader(outputfile);
			String[] nextRecord;
			
			while((nextRecord = reader.readNext()) != null) {
				if(!nextRecord[0].equals("Name")) {
					contact = new Contact();
					contact.setName(nextRecord[0]);
					contact.setPhone(nextRecord[1]);
					contact.setAddress(nextRecord[2]);
					contacts.add(contact);
				}
			}
			reader.close();
			return contacts;
			

		} catch (IOException e) {
			return null;
		}
	}
}
