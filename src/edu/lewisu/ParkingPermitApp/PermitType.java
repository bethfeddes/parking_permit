package edu.lewisu.ParkingPermitApp;

public enum PermitType {

	RESIDENT("Resident"),
	COMMUTER("Commuter");
	
	private final String displayName;
	
	PermitType(String displayName) {
		this.displayName = displayName;
	}
	
	public String getDisplayName() {
		return this.displayName;
	}
	
}
