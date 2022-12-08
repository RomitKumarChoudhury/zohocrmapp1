package com.zohocrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.entities.Billing;
import com.zohocrm.entities.Contact;
import com.zohocrm.entities.Lead;
import com.zohocrm.service.BillingService;
import com.zohocrm.service.ContactService;

@Controller
public class ContactController {
	
	private ContactService contactService;
	
	public ContactController(ContactService contactService) {
		this.contactService = contactService;
	}
	@GetMapping("/listAllContact")
	public String listAllContacts(Model model) {
		List<Contact> contacts = contactService.getAllContact();
		model.addAttribute("contacts", contacts);
		return "list_contact";
	}
	@RequestMapping("/contactInfo")
	public String leadInfo(@RequestParam("id") long id, Model model) {
		Contact contact = contactService.findLeadById(id);
		List<Contact> contacts = contactService.getAllContact();
		model.addAttribute("contacts", contacts);
		return"list_bill";
		
	}
	@RequestMapping("/deleteContact")
	public String deleteContacts(@RequestParam("id") long id, Model model) {
		model.addAttribute("msg", "Contact is deleted...");
		contactService.deleteOneContact(id);
		List<Contact> contacts = contactService.getAllContact();
		model.addAttribute("contacts", contacts);
		return "list_contact";
	}
}
