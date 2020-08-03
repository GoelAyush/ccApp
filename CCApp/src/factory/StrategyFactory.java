package factory;

import interfaces.CreditLimitStrategy;
import strategy.AugustCreditLimitStrategy;
import strategy.FestiveSeasonCreditStrategy;

public class StrategyFactory {

	public static CreditLimitStrategy getLimitStrategy() {
		// Based on terms and conditions return a strategy to determine balance
		boolean someOffer = true; // "offerPeriod"
		if (someOffer) {
			return new FestiveSeasonCreditStrategy();

		} else {
			return new AugustCreditLimitStrategy();
		}
	}
}
