package model;

import abstractClass.CreditCardAbs;
import abstractClass.TransactionAbs;
import enums.TransactionType;
import exception.WrongTransactionTypeException;
import factory.ValidatorFactory;
import interfaces.Card;

public class CardPaymentTransaction extends TransactionAbs {

	public CardPaymentTransaction(Double transactionAmount, TransactionType txnType) {
		this.transactionAmount = transactionAmount;
		this.txnType = txnType;
	}

	@Override
	public void doTransaction(Card card) {
		CreditCardAbs cardAbs = ((CreditCardAbs) card);
		Double amount = this.getTransactionAmount();
		// 1. 
		if(amount > 0) { 
			if(amount >= cardAbs.getPastCashDue())
			{
				amount = amount - cardAbs.getPastCashDue();
				cardAbs.setPastCashDue(0D);
			} else
			{
				amount = 0D;
				cardAbs.setPastCashDue(cardAbs.getPastCashDue() - amount);
			}
			//Increase current Cash limit 
			cardAbs.setCurrentUtilisedCash(cardAbs.getCurrentUtilisedCash() - cardAbs.getPastCashDue());
		}
		
		if(amount > 0) { 
			if(amount >= cardAbs.getPastCreditDue())
			{
				amount = amount - cardAbs.getPastCreditDue();
				cardAbs.setPastCreditDue(0D);
			} else
			{
				amount = 0D;
				cardAbs.setPastCreditDue(cardAbs.getPastCreditDue() - amount);
			}
			//Increase current Credit limit 
			cardAbs.setCurrentUtilisedCredit(cardAbs.getCurrentUtilisedCredit() - cardAbs.getPastCreditDue());
		}
		
		if(amount > 0) { 
			if(amount >= cardAbs.getCurrentCashDue())
			{
				amount = amount - cardAbs.getCurrentCashDue();
				cardAbs.setCurrentCashDue(0D);
			} else
			{
				amount = 0D;
				cardAbs.setCurrentCashDue(cardAbs.getCurrentCashDue() - amount);
			}
			//Increase current Cash limit 
			cardAbs.setCurrentUtilisedCash(cardAbs.getCurrentUtilisedCash() - cardAbs.getPastCashDue());
		}
		
		if(amount > 0) { 
			if(amount >= cardAbs.getCurrentCreditDue())
			{
				amount = amount - cardAbs.getCurrentCreditDue();
				cardAbs.setCurrentCreditDue(0D);
			} else
			{
				amount = 0D;
				cardAbs.setCurrentCreditDue(cardAbs.getCurrentCreditDue() - amount);
			}
			cardAbs.setCurrentUtilisedCredit(cardAbs.getCurrentUtilisedCredit() - cardAbs.getPastCreditDue());
		}
		
		// 5. Record extra payment for future
		if(amount > 0)
			cardAbs.setExtraPayment(cardAbs.getExtraPayment() + amount);
		
	}

	@Override
	public boolean validateTransaction(Card card) throws WrongTransactionTypeException {
		return ValidatorFactory.getCardPaymentTransactionValidator(card.getCardOwner()).validateTransaction(this,
				(CreditCardAbs) card);
	}
}
