package edu.lewisu.ParkingPermitApp;

import java.math.BigDecimal;

public class CommuterPricingStrategy implements PricingStrategy {

	private static final BigDecimal BASE_PRICE = new BigDecimal("35");
	
	@Override
	public BigDecimal computeMonthly(PermitSelection sel) {
		return BASE_PRICE;
	}
	
}