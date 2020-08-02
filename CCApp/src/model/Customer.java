package model;

import interfaces.Card;

public class Customer {

	Long customerID;
	String name;
	String address;
	Long contactNumber;
	Card creditCard;

	public Customer(Long customerID, String name, String address, Long contactNumber) {
		super();
		this.customerID = customerID;
		this.name = name;
		this.address = address;
		this.contactNumber = contactNumber;
	}

	public Card getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(Card creditCard) {
		this.creditCard = creditCard;
	}

	public boolean hasActiveCreditCard() {
		return creditCard != null && creditCard.getStatus() == CardStatus.ACTIVE;
	}
}
