package validator;

import abstractClass.CreditCardAbs;
import enums.TransactionType;
import exception.WrongTransactionTypeException;
import interfaces.Transaction;
import interfaces.ValidatorI;

public class CardPaymentTransactionValidator implements ValidatorI {

	@Override
	public boolean validateTransaction(Transaction t, CreditCardAbs card) throws WrongTransactionTypeException {
		if (t.getTxnType() != TransactionType.CREDIT)
			throw new WrongTransactionTypeException();
		
		return t.getTransactionAmount() >  card.getCurrentUtilisedCash() + card.getCurrentUtilisedCash() ? false : true;
	}

}
