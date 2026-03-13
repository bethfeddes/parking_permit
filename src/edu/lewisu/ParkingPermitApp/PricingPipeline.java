package edu.lewisu.ParkingPermitApp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class PricingPipeline {

	// Initialize list to store modifiers
	private final List<RateModifier> modifiers = new ArrayList<>();
	
	public void addModifier(RateModifier modifier) {
		modifiers.add(modifier);
	}
	
	public BigDecimal apply(BigDecimal monthly) {
		
		for (RateModifier mod : modifiers) {
			monthly = mod.apply(monthly);
		}
		return monthly;
	}
	
}
