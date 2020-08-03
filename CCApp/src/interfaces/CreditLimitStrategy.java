package interfaces;

import model.Customer;

public interface CreditLimitStrategy {
	// Determines how much credit can be issued to a given customer based on various
	// metrics, which can change
	public Double getCashBalance(Customer customer);

	public Double getPOSBalance(Customer customer);

	public int getValidityDays(Customer customer);

	public boolean shouldIssueCard(Customer customer);
}
