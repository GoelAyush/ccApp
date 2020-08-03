package validator;

import abstractClass.CreditCardAbs;
import enums.TransactionType;
import exception.WrongTransactionTypeException;
import interfaces.Transaction;
import interfaces.ValidatorI;

public class POSValidator implements ValidatorI {

	@Override
	public boolean validateTransaction(Transaction t, CreditCardAbs card) throws WrongTransactionTypeException {
		if(t.getTxnType() != TransactionType.DEBIT)
			throw new WrongTransactionTypeException();
		
		return t.getTransactionAmount() > (card.getCreditLimit() - card.getCurrentUtilisedCredit()) ? false : true;
	}

}
