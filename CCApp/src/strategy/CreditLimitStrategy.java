package strategy;

import model.Customer;

public interface CreditLimitStrategy {
	public Double getCashBalance(Customer customer);
	public Double getPOSBalance(Customer customer);
	public int getValidityDays(Customer customer);
}
