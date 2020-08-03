package service;

import exception.NoCardForCustomerException;
import factory.StrategyFactory;
import interfaces.CreditLimitStrategy;
import model.Bank;
import model.Customer;
import pojo.EOMPStatement;

public class CardManager {

	// Injected as per prevailing situations
	private CreditLimitStrategy strategyInstance = StrategyFactory.getLimitStrategy();
	private Bank bankInstance = new Bank("ABP Bank", "Hyderabad");

	public boolean requestCard(Customer customer) throws Exception {
		if (strategyInstance.shouldIssueCard(customer)) {
			Double cashBal = strategyInstance.getCashBalance(customer);
			Double POSBal = strategyInstance.getPOSBalance(customer);
			int validDays = strategyInstance.getValidityDays(customer);
			if (POSBal > 0D)
				return bankInstance.issueCard(customer, cashBal, POSBal, validDays);
		}
		return false;
	}

	public boolean blockCard(Customer customer) {
		if (customer.getCreditCard() != null) {
			return customer.getCreditCard().blockCard();
		}
		return false;
	}

	public boolean activateCard(Customer customer) throws NoCardForCustomerException {
		if (customer.getCreditCard() != null) {
			return customer.getCreditCard().activateCard();
		}
		throw new NoCardForCustomerException();

	}
	
	public EOMPStatement runEOMP(Customer customer) throws NoCardForCustomerException
	{
		if (customer.getCreditCard() != null) {
			return customer.getCreditCard().runEOMP();
		}
		throw new NoCardForCustomerException();
	}
}
