package model;

import abstractClass.CreditCardAbs;
import abstractClass.TransactionAbs;
import enums.TransactionType;
import exception.WrongTransactionTypeException;
import factory.ValidatorFactory;
import interfaces.Card;

public class MoneyWithdrawTransaction extends TransactionAbs {

	@Override
	public void doTransaction(Card card) {
		((CreditCardAbs) card)
				.setCurrentUtilisedCash(((CreditCardAbs) card).getCurrentUtilisedCash() + this.getTransactionAmount());
	}

	public MoneyWithdrawTransaction(Double transactionAmount, TransactionType txnType) {
		this.transactionAmount = transactionAmount;
		this.txnType = txnType;

	}

	@Override
	public boolean validateTransaction(Card card) throws WrongTransactionTypeException {
		return ValidatorFactory.getMoneyWithdrawTransactionValidator(card.getCardOwner()).validateTransaction(this,
				(CreditCardAbs) card);
	}

}
