package interfaces;

import enums.TransactionType;
import exception.WrongTransactionTypeException;

public interface Transaction {
	
	public void doTransaction(Card card);

	public Double getTransactionAmount();

	public TransactionType getTxnType();

	public boolean validateTransaction(Card card) throws WrongTransactionTypeException;
}
