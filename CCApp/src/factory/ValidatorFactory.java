package factory;

import interfaces.ValidatorI;
import validator.CreditCardBalValidator;

public class ValidatorFactory {
	
	public static ValidatorI getValidator()
	{
		return new CreditCardBalValidator();
	}
}
