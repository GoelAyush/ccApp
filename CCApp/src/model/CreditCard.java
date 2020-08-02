package model;

import java.util.Date;

import factory.ValidatorFactory;
import validator.ValidatorI;

public class CreditCard extends CardAbs {
	
	Double currCashBal;
	Double currPOSBal;
	private CardStatus status;
	private ValidatorI validator = ValidatorFactory.getValidator();
	
	public CardStatus getStatus() {
		return status;
	}

	public void setStatus(CardStatus status) {
		this.status = status;
	}

	// Credit Must
	public CreditCard (Date expiryDate, Customer cardOwner, Double currPOSBal)
	{
		this.cardOwner = cardOwner;
		this.expiryDate = expiryDate;
		this.currPOSBal = currPOSBal;
		this.currCashBal = 0D;
		this.status = CardStatus.CLOSED;
	}
	
	public boolean doTransaction(Transaction t)
	{
		if(validator.validateTransaction(t, this))
		{
			t.doTransaction(this);
			return true;
		}
		return false;
	}
	
	// Cash 
	public CreditCard (Date expiryDate, Customer cardOwner, Double currPOSBal, Double currCashBal)
	{
		this.cardOwner = cardOwner;
		this.expiryDate = expiryDate;
		this.currPOSBal = currPOSBal;
		this.currCashBal = currCashBal;
		this.status = CardStatus.CLOSED;
	}

	@Override
	public boolean blockCard() {
		// Perform Business Validations 
		this.status =  CardStatus.CLOSED;
		return true;
	}

	@Override
	public boolean activateCard() {
		// Perform Business Validations 
		this.status =  CardStatus.ACTIVE;
		return true;
	}
	
}
