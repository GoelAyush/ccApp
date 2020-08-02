package strategy;

import model.Customer;

public class AugustCreditLimitStrategy implements CreditLimitStrategy {
	
	@Override
	public Double getCashBalance(Customer customer) {
		// Based on customer profile
		return new Double("Some Number");
	}

	@Override
	public Double getPOSBalance(Customer customer) {
		// Based on customer profile
		return new Double("Some Number");
	}

	@Override
	public int getValidityDays(Customer customer) {
		return new Integer("Some Number");
	}
}
