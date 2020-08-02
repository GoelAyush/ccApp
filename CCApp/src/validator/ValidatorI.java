package validator;

import model.Card;
import model.Transaction;

public interface ValidatorI {
	boolean validateTransaction(Transaction t, Card card);
}
