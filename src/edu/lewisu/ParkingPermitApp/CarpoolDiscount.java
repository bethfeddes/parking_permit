package edu.lewisu.ParkingPermitApp;

import java.math.BigDecimal;

public class CarpoolDiscount implements RateModifier {

	private static final BigDecimal ADJUSTMENT = new BigDecimal("-0.10");
	
	public BigDecimal getCPDiscount() {
		return CarpoolDiscount.ADJUSTMENT;
	}
	
	@Override
	public BigDecimal apply(BigDecimal currentMonthly) {
		BigDecimal change = currentMonthly.multiply(ADJUSTMENT);
		return currentMonthly.add(change);	
	}
	
}
