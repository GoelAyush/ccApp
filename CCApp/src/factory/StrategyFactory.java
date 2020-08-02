package factory;

import interfaces.CreditLimitStrategy;
import strategy.AugustCreditLimitStrategy;

public class StrategyFactory {

	
	public static CreditLimitStrategy getLimitStrategy()
	{
		return new AugustCreditLimitStrategy();
		// Based on terms and conditions return a strategy to give balance
	}
	
}
