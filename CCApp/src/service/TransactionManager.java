package service;

import model.CardPaymentTransaction;
import model.Customer;
import model.MoneyWithdrawTransaction;
import model.POSTransaction;

public class TransactionManager {

	public boolean withdrawMoneyRequest(Customer customer, Double amount) {
		if (customer.hasActiveCreditCard()) {
			// Can use a Factory as well here 
			customer.getCreditCard().doTransaction(new MoneyWithdrawTransaction());
		}
		return true;
	}

	public boolean posTxnRequest(Customer customer) {
		if (customer.hasActiveCreditCard()) {
			customer.getCreditCard().doTransaction(new POSTransaction());
		}
		return true;
	}

	public boolean makePayment(Customer customer) {
		if (customer.hasActiveCreditCard()) {
			customer.getCreditCard().doTransaction(new CardPaymentTransaction());
		}
		return true;
	}
}
