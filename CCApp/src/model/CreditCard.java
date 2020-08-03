package model;

import java.util.ArrayList;
import java.util.Date;

import abstractClass.CreditCardAbs;
import enums.CardStatus;
import exception.WrongTransactionTypeException;
import interfaces.Transaction;
import pojo.EOMPStatement;

public class CreditCard extends CreditCardAbs {

	private CardStatus status;

	public CardStatus getStatus() {
		return status;
	}

	// Credit Must
	public CreditCard(Date expiryDate, Customer cardOwner, Double currPOSBal) {
		this.cardOwner = cardOwner;
		this.expiryDate = expiryDate;
		this.creditLimit = currPOSBal;
		this.cashLimit = 0D;
		this.status = CardStatus.CLOSED;
		this.pastStatments = new ArrayList <EOMPStatement>();
	}

	// Cash
	public CreditCard(Date expiryDate, Customer cardOwner, Double currPOSBal, Double currCashBal) {
		this.cardOwner = cardOwner;
		this.expiryDate = expiryDate;
		this.creditLimit = currPOSBal;
		this.cashLimit = currCashBal;
		this.status = CardStatus.CLOSED;
	}

	@Override
	public EOMPStatement runEOMP() {
		EOMPStatement statement = new EOMPStatement();
		Double totalDue = currentUtilisedCash + currentUtilisedCredit;
		Double interest = 0.02 * this.getPastCashDue() + 0.02 * this.getCurrentCashDue() + 0.02 * this.getPastCreditDue();
		statement.setTotalAmountDue(totalDue + interest); 
		statement.setMinAmountDue(interest);
		statement.setStatementNo(pastStatments.size() + 1);
		statement.setInterestDue(interest);
		pastStatments.add(statement);
		return statement;
	}

	public boolean doTransaction(Transaction t) throws WrongTransactionTypeException {
		if (t.validateTransaction(this)) {
			t.doTransaction(this);
			return true;
		}
		return false;
	}

	@Override
	public boolean blockCard() {
		// Perform Business Validations
		this.status = CardStatus.CLOSED;
		return true;
	}

	@Override
	public boolean activateCard() {
		// Perform Business Validations
		this.status = CardStatus.ACTIVE;
		return true;
	}

	public void setStatus(CardStatus status) {
		this.status = status;
	}

}
