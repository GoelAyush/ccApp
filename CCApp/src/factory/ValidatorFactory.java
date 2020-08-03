package factory;

import interfaces.ValidatorI;
import model.Customer;
import validator.CardPaymentTransactionValidator;
import validator.MoneyWithdrawTransactionValidator;
import validator.POSValidator;

public class ValidatorFactory {

	// based on the customer type and card type returns a validator
	// instance which can check if a transaction should be allowed or not
	public static ValidatorI getPOSValidator(Customer customers) {
		// PREMIUM
//		if (customers)
//		{
		return new POSValidator();
//		}
//		// STANDARD
//		else if (customers)
//		{
//			
//		}
	}

	public static ValidatorI getMoneyWithdrawTransactionValidator(Customer customers) {
		// PREMIUM
//		if (customers)
//		{
		return new MoneyWithdrawTransactionValidator();
//		}
//		// STANDARD
//		else if (customers)
//		{
//			
	}

	public static ValidatorI getCardPaymentTransactionValidator(Customer customers) {
		// PREMIUM
//		if (customers)
//		{
		return new CardPaymentTransactionValidator();
//		}
//		// STANDARD
//		else if (customers)
//		{
//			
//		}
	}

}
