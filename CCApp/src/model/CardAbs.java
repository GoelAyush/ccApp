package model;

import java.util.Date;

public abstract class CardAbs implements Card {
	Date issueDate;
	Date expiryDate;
	Customer cardOwner;
}
