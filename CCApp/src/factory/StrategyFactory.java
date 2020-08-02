package factory;

import strategy.AugustCreditLimitStrategy;
import strategy.CreditLimitStrategy;

public class StrategyFactory {

	
	public static CreditLimitStrategy getLimitStrategy()
	{
		return new AugustCreditLimitStrategy();
		// Based on terms and conditions return a strategy to give balance
	}
	
}
