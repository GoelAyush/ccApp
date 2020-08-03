package abstractClass;

import java.util.Date;
import java.util.List;

import interfaces.Card;
import model.Customer;
import pojo.EOMPStatement;

public abstract class CreditCardAbs implements Card {
	
	
	protected Date issueDate;
	protected Date expiryDate;
	protected Customer cardOwner;
	protected Double cashLimit; // aka cash Limit
	protected Double creditLimit; // aka 
	protected Double currentUtilisedCredit;
	protected Double currentUtilisedCash;
	protected Double minAmountDue;
	protected Double currentCashDue;
	protected Double currentCreditDue;
	protected Double pastCashDue;
	protected Double pastCreditDue;
	protected Double extraPayment;
	protected List <EOMPStatement> pastStatments;

	public Double getCashLimit() {
		return cashLimit;
	}

	public Double getMinAmountDue() {
		return minAmountDue;
	}

	public void setMinAmountDue(Double minAmountDue) {
		this.minAmountDue = minAmountDue;
	}

	public Double getCurrentCashDue() {
		return currentCashDue;
	}

	public void setCurrentCashDue(Double currentCashDue) {
		this.currentCashDue = currentCashDue;
	}

	public Double getCurrentCreditDue() {
		return currentCreditDue;
	}

	public void setCurrentCreditDue(Double currentCreditDue) {
		this.currentCreditDue = currentCreditDue;
	}

	public Double getPastCashDue() {
		return pastCashDue;
	}

	public void setPastCashDue(Double pastCashDue) {
		this.pastCashDue = pastCashDue;
	}

	public Double getPastCreditDue() {
		return pastCreditDue;
	}

	public void setPastCreditDue(Double pastCreditDue) {
		this.pastCreditDue = pastCreditDue;
	}

	public void setCashLimit(Double cashLimit) {
		this.cashLimit = cashLimit;
	}

	public Double getExtraPayment() {
		return extraPayment;
	}

	public void setExtraPayment(Double extraPayment) {
		this.extraPayment = extraPayment;
	}

	public Double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(Double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public Double getCurrentUtilisedCredit() {
		return currentUtilisedCredit;
	}

	public void setCurrentUtilisedCredit(Double currentUtilisedCredit) {
		this.currentUtilisedCredit = currentUtilisedCredit;
	}

	public Double getCurrentUtilisedCash() {
		return currentUtilisedCash;
	}

	public void setCurrentUtilisedCash(Double currentUtilisedCash) {
		this.currentUtilisedCash = currentUtilisedCash;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Customer getCardOwner() {
		return cardOwner;
	}

	public void setCardOwner(Customer cardOwner) {
		this.cardOwner = cardOwner;
	}
}
