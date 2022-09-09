package com.neu.phonebook.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.neu.phonebook.dao.ContactDao;
import com.neu.phonebook.dao.UserDAO;
import com.neu.phonebook.model.Contact;
import com.neu.phonebook.model.User;
import com.opencsv.CSVWriter;

@Controller
public class DownloadContactListController {

	@Autowired
	UserDAO userDAO;

	@Autowired
	ContactDao contactDao;

	@GetMapping(value = "/download")
	public ModelAndView downloadContactList(HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("username");
		User user = userDAO.get(username);
		List<Contact> contacts = contactDao.getContactList(user);
		writeContactsFile(contacts);
		return new ModelAndView("downloadSuccess");
	}

	private void writeContactsFile(List<Contact> contacts) {

		File file = new File("/Users/sunitbail/Downloads/contacts/contacts.csv");
		try {
			FileWriter outputfile = new FileWriter(file);
			CSVWriter writer = new CSVWriter(outputfile);
			String[] header = { "Name", "Phone", "Address" };
			writer.writeNext(header);
			for (Contact contact : contacts) {
				header[0] = contact.getName();
				header[1] = contact.getPhone();
				header[2] = contact.getAddress();

				writer.writeNext(header);
			}
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
