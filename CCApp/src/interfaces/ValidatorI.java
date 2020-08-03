package interfaces;

import abstractClass.CreditCardAbs;
import exception.WrongTransactionTypeException;

public interface ValidatorI {
	boolean validateTransaction(Transaction t, CreditCardAbs card) throws WrongTransactionTypeException;
}
