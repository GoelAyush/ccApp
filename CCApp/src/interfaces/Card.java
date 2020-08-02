package interfaces;

import model.CardStatus;

public interface Card {
	public boolean blockCard();
	public boolean activateCard();
	public boolean doTransaction(Transaction t);
	public CardStatus getStatus();
}
