package interfaces;

import enums.CardStatus;
import exception.WrongTransactionTypeException;
import model.Customer;
import pojo.EOMPStatement;

public interface Card {

	public boolean blockCard();

	public boolean activateCard();

	public boolean doTransaction(Transaction t) throws WrongTransactionTypeException;

	public CardStatus getStatus();

	public Customer getCardOwner();
	
	public EOMPStatement runEOMP(); 

}
