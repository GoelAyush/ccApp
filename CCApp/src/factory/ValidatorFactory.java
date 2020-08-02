package factory;

import validator.CreditCardBalValidator;
import validator.ValidatorI;

public class ValidatorFactory {
	
	public static ValidatorI getValidator()
	{
		return new CreditCardBalValidator();
	}
}
