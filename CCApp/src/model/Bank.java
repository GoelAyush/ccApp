package model;

import java.util.Date;
import java.util.HashMap;

import exception.CardAlreadyIssuedException;

public class Bank {

	String name;
	String address;
	HashMap<Integer, Customer> customerMap;

	public Bank(String name, String address) {
		super();
		this.name = name;
		this.address = address;
		customerMap = new HashMap<Integer, Customer>();
	}

	public boolean issueCard(Customer customer, Double cashBal, Double posBal, int expiryDays)
			throws CardAlreadyIssuedException {
		if (customer.getCreditCard() == null) {
			if (cashBal == 0D)
				customer.setCreditCard(new CreditCard(new Date(), customer, posBal));
			else
				customer.setCreditCard(new CreditCard(new Date(), customer, posBal, cashBal));
		} else {
			throw new CardAlreadyIssuedException();
		}
		return true;
	}
}
