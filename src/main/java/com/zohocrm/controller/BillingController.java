package com.zohocrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.entities.Billing;
import com.zohocrm.entities.Contact;
import com.zohocrm.service.BillingService;
import com.zohocrm.service.ContactService;

@Controller
public class BillingController {
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private BillingService billingService;
	
	@RequestMapping("/generateBill")
	public String viewBillingPage(@RequestParam("id") long id, Model model) {
		Contact contact = contactService.getContactById(id);

		Billing bill = new Billing();
		bill.setFirstName(contact.getFirstName());
		bill.setLastName(contact.getLastName());
		bill.setEmail(contact.getEmail());
		bill.setMobile(contact.getMobile());
		
		billingService.saveOneBill(bill);
		contactService.deleteOneContact(id);
		List<Billing> bills = billingService.listAllBill();
		model.addAttribute("bills", bills);
		model.addAttribute("contact", contact);
		return "generate_bill";
				
	}
	@RequestMapping("/saveBill")
	public String saveBill(@ModelAttribute("billing") Billing bill, Model model) {
		billingService.saveOneBill(bill);	
		List<Billing> bills = billingService.listAllBill();
		model.addAttribute("bills", bills);
		return "list_bill";
		
	}
	@RequestMapping("/listBill")
	public String listAllBill(Model model) {
		List<Billing> bills = billingService.listAllBill();
		model.addAttribute("bills", bills);
		return "list_bill";
	}
	@RequestMapping("/deleteBill")
	public String deleteContacts(@RequestParam("id") long id, Model model) {
		model.addAttribute("msg", "Bill is deleted...");
		billingService.deleteOneBill(id);
		List<Billing> bills = billingService.listAllBill();
		model.addAttribute("bills", bills);
		return "list_bill";
	}
}
