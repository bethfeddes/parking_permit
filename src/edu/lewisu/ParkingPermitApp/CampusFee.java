package edu.lewisu.ParkingPermitApp;

import java.math.BigDecimal;

public class CampusFee implements RateModifier{

	private static final BigDecimal FEE = new BigDecimal("0.05");
		
	public BigDecimal getFee() {
		return CampusFee.FEE;
	}
	
	@Override
	public BigDecimal apply(BigDecimal subtotal) {
		return subtotal.multiply(FEE);
	}
		
}
