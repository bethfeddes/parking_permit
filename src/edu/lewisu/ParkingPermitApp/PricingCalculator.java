package edu.lewisu.ParkingPermitApp;

import java.math.BigDecimal;

public class PricingCalculator implements Validatable {

	private BigDecimal baseMonthly;
	private BigDecimal monthly;
	private BigDecimal subtotal;
	private BigDecimal total;
	private BigDecimal vehicleRate;

	public void calculate(PermitSelection sel) {

		// Validate input
		sel.validate();

		// Determine permit type
		PricingStrategy strategy = sel.getPermit() == PermitType.RESIDENT
				? new ResidentPricingStrategy()
				: new CommuterPricingStrategy();

		// Store base cost before any adjustments
		baseMonthly = strategy.computeMonthly(sel);

		PricingPipeline pipeline = new PricingPipeline();
		pipeline.addModifier(sel.getVehicle());

		// Store vehicle rate before adding carpool
		vehicleRate = sel.getVehicle().apply(baseMonthly);
        monthly = pipeline.apply(baseMonthly);

		if (sel.getCarpool()) {
            monthly = new CarpoolDiscount().apply(vehicleRate);
		}

		subtotal = monthly.multiply(new BigDecimal(sel.getMonths()));

		BigDecimal feeAmount = new CampusFee().apply(subtotal);

		total = subtotal.add(feeAmount);

	}

    @Override
    public void validate() {
        if (baseMonthly == null || vehicleRate == null || monthly == null || subtotal == null || total == null) {
            throw new IllegalStateException("calculate() must be called before retrieving results.");
        }
    }

	public BigDecimal getBaseMonthly() {
		return baseMonthly;
	}
	public BigDecimal getVehicleRate() {
		return vehicleRate;
	}
	public BigDecimal getMonthly() {
		return monthly;
	}
	public BigDecimal getSubTotal() {
		return subtotal;
	}
	public BigDecimal getTotal() {
		return total;
	}
}