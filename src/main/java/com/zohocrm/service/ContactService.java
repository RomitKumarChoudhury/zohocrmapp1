package com.zohocrm.service;

import java.util.List;

import com.zohocrm.entities.Contact;
import com.zohocrm.entities.Lead;

public interface ContactService {
	
	public void saveContact(Contact contact);

	public List<Contact> getAllContact();

	public Contact findLeadById(long id);

	public Contact getContactById(long id);

	public void deleteOneContact(long id);


}
