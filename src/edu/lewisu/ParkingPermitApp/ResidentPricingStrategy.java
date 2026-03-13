package edu.lewisu.ParkingPermitApp;

import java.math.BigDecimal;

public class ResidentPricingStrategy implements PricingStrategy {

	private static final BigDecimal BASE_PRICE = new BigDecimal("45");
	
	@Override
	public BigDecimal computeMonthly(PermitSelection sel) {
		return BASE_PRICE;
	}
	
}
