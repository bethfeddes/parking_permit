package edu.lewisu.ParkingPermitApp;

import java.math.BigDecimal;

public class Receipt {

	// Console display
	public void display(PermitSelection sel, BigDecimal baseMonthly, BigDecimal vehicleRate, BigDecimal monthly,
			BigDecimal subtotal,
			BigDecimal total) {

        System.out.println("\n  --------------------------");
		System.out.println("-|* Parking Permit Receipt *|-");
		System.out.println("  --------------------------");
		System.out.printf("Permit type: %s ($%.2f)%n", sel.getPermit().getDisplayName(), baseMonthly.doubleValue());

		// Print vehicle type / info
		System.out.printf("Vehicle type: %s (%.0f%%) -> $%.2f%n",
				sel.getVehicle().getDisplayName(),
				sel.getVehicle().getAdjustment().multiply(new BigDecimal("100")).doubleValue(),
				vehicleRate.doubleValue());

		// Display carpool discount only if they have it
		if (sel.getCarpool()) {
			CarpoolDiscount carpool = new CarpoolDiscount();
			BigDecimal adjustment = carpool.getCPDiscount();
			System.out.printf("Carpool Discount (%.0f%%): $%.2f%n",
					adjustment.multiply(new BigDecimal("100")).doubleValue(), monthly.doubleValue());
		}

		System.out.printf("Subtotal (%d months) = $%.2f%n", sel.getMonths(), subtotal);

		// Show campus fee amount and percentage
		BigDecimal campusFee = total.subtract(subtotal);

		System.out.printf("Campus Fee (%.0f%%): $%.2f%n",
				CampusFee.getFee().multiply(new BigDecimal("100")).doubleValue(), campusFee.doubleValue());

		System.out.printf("Total = $%.2f%n", total);
	}
}