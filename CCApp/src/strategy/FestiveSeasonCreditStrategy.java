package strategy;

import interfaces.CreditLimitStrategy;
import model.Customer;

public class FestiveSeasonCreditStrategy implements CreditLimitStrategy {

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
		// Based on customer profile
		return new Integer("Some Number");
	}

	@Override
	public boolean shouldIssueCard(Customer customer) {
		// Based on customer profile
		return true;
	}

}
