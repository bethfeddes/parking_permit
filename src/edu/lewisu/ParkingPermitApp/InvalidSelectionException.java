package edu.lewisu.ParkingPermitApp;

public class InvalidSelectionException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	public InvalidSelectionException() {
		super();
	}
	public InvalidSelectionException(String message) {
		super(message);
	}
	public InvalidSelectionException(Throwable cause) {
		super(cause);
	}
	public InvalidSelectionException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
