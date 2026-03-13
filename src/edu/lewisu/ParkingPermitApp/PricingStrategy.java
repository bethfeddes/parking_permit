package edu.lewisu.ParkingPermitApp;

public interface PricingStrategy {

	java.math.BigDecimal computeMonthly(PermitSelection sel);
	
}
