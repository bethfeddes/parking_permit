package edu.lewisu.ParkingPermitApp;

import java.math.BigDecimal;

public enum VehicleType implements RateModifier {

	CAR("Car",BigDecimal.ZERO),
	SUV("SUV", new BigDecimal("0.15")),
	MOTORCYCLE("Motorcycle", new BigDecimal("-0.30"));
	
	private final String displayName;
	private final BigDecimal adjustment;
	
	VehicleType(String displayName, BigDecimal adjustment) {
		this.displayName = displayName;
		this.adjustment = adjustment;
	}
	
	public String getDisplayName() {
		return displayName;
	}
	
	public BigDecimal getAdjustment() {
		return adjustment;
	}
	
	
	@Override
	public BigDecimal apply(BigDecimal currentMonthly) {
		BigDecimal change = currentMonthly.multiply(adjustment);
		return currentMonthly.add(change);
	}
	
}
