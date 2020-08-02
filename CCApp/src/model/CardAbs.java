package model;

import java.util.Date;

import interfaces.Card;

public abstract class CardAbs implements Card {
	Date issueDate;
	Date expiryDate;
	Customer cardOwner;
}
