package service;

import enums.TransactionType;
import exception.WrongTransactionTypeException;
import model.CardPaymentTransaction;
import model.Customer;
import model.MoneyWithdrawTransaction;
import model.POSTransaction;

public class TransactionManager {

	public boolean withdrawMoneyRequest(Customer customer, Double amount) throws WrongTransactionTypeException {
		if (customer.hasActiveCreditCard()) {
			// Can use a Factory as well here
			customer.getCreditCard().doTransaction(new MoneyWithdrawTransaction(amount, TransactionType.DEBIT));
		}
		return true;
	}

	public boolean posTxnRequest(Customer customer, Double amount) throws WrongTransactionTypeException {
		if (customer.hasActiveCreditCard()) {
			customer.getCreditCard().doTransaction(new POSTransaction(amount, TransactionType.DEBIT));
		}
		return true;
	}

	public boolean makePayment(Customer customer, Double amount) throws WrongTransactionTypeException {
		if (customer.hasActiveCreditCard()) {
			customer.getCreditCard().doTransaction(new CardPaymentTransaction(amount, TransactionType.CREDIT));
		}
		return true;
	}
}
