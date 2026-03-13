package edu.lewisu.ParkingPermitApp;

public interface RateModifier {

	java.math.BigDecimal apply(java.math.BigDecimal currentMonthly);
	
}
