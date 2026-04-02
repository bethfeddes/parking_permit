package edu.lewisu.ParkingPermitApp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PricingPipeline implements Validatable {

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

    @Override
    public  void validate() {
        if (modifiers.isEmpty()) {
            throw new IllegalStateException("No modifiers defined");
        }
        if (modifiers.contains(null)) {
            throw new IllegalStateException("PricingPipeline has a null modifier");
        }
    }

}
