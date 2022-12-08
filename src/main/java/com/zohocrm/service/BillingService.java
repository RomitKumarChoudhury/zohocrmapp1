package com.zohocrm.service;

import java.util.List;

import com.zohocrm.entities.Billing;

public interface BillingService {

	public void saveOneBill(Billing bill);

	public List<Billing> listAllBill();
	
	public void deleteOneBill(long id);
	
	
}
