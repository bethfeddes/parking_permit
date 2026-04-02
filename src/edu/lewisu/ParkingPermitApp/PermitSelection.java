package edu.lewisu.ParkingPermitApp;

public class PermitSelection implements Validatable {

	private final PermitType permit;
	private final VehicleType vehicle;
	private final boolean carpool;
	private final int months;

	public PermitSelection(PermitType permit, VehicleType vehicle, boolean carpool, int months) {
		this.permit = permit;
		this.vehicle = vehicle;
		this.carpool = carpool;
		this.months = months;
	}

	public PermitType getPermit() {
		return permit;
	}

	public VehicleType getVehicle() {
		return vehicle;
	}

	public boolean getCarpool() {
		return carpool;
	}

	public int getMonths() {
		return months;
	}

	@Override
	public void validate() {
		if (permit == null) {
			throw new InvalidSelectionException("Permit must be selected.");
		}

		if (vehicle == null) {
			throw new InvalidSelectionException("Vehicle type must be selected.");
		}

		if (months <= 0 || months > 12) {
			throw new InvalidSelectionException("Months must be between 1 and 12.");
		}
	}
}
