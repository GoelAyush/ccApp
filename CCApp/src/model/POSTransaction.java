package model;

import abstractClass.CreditCardAbs;
import abstractClass.TransactionAbs;
import enums.TransactionType;
import exception.WrongTransactionTypeException;
import factory.ValidatorFactory;
import interfaces.Card;

public class POSTransaction extends TransactionAbs {

	@Override
	public void doTransaction(Card card) {
		((CreditCardAbs) card)
		.setCurrentUtilisedCredit(((CreditCardAbs) card).getCurrentUtilisedCredit() + this.getTransactionAmount());
	}

	public POSTransaction(Double transactionAmount, TransactionType txnType) {
		this.transactionAmount = transactionAmount;
		this.txnType = txnType;
	}

	@Override
	public boolean validateTransaction(Card card) throws WrongTransactionTypeException {
		return ValidatorFactory.getPOSValidator(card.getCardOwner()).validateTransaction(this,
				(CreditCardAbs) card);
	}

}
