package edu.lewisu.ParkingPermitApp;

// TEMPORARILY HARD-CODING MENUS FOR TIME SAKE, COME BACK AND FIX
// ALSO FIX APPEARANCE OF RECEIPT 
// FORMAT NICER
// INVESTIGATE ISSUE WITH INPUT 12 MONTHS FOR "MONTHS"

import java.util.EnumSet;
import java.util.InputMismatchException;
import java.math.BigDecimal;
import java.util.Scanner;

public class ParkingPermitApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		// Welcome message
		System.out.println("-|* Welcome to the Parking Permit App *|-");
		System.out.println("  -------------------------------------");
			
		// Permit type menu
		System.out.println("Permit type -");
		System.out.println("1) Resident");
		System.out.println("2) Commuter");
			
		PermitType permit = null;
		
		// Get permit type input
		while (permit == null) {
			try {
				System.out.println("Select option: ");
				int permitChoice = sc.nextInt();
				
				if (permitChoice == 1) {
					permit = PermitType.RESIDENT;
				}
				else if (permitChoice ==2) {
					permit = PermitType.COMMUTER;
				}
				else {
					System.out.println("Choice must be 1 or 2.");
				}
			}
			catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a number.");
				sc.next(); // Clears invalid input
			}
		}
			
		// Vehicle type menu
		System.out.println("\nVehicle type -");
		System.out.println("1) Car");
		System.out.println("2) SUV");
		System.out.println("3) Motorcycle");

		
		VehicleType vehicle = null;
		
		// Get vehicle input
		while (vehicle == null) {
			try {
				System.out.println("Select option: ");
				int vehicleChoice = sc.nextInt();
					
				switch (vehicleChoice) {
					case 1:
						vehicle = VehicleType.CAR;
						break;
					case 2:
						vehicle = VehicleType.SUV;
						break;
					case 3:
						vehicle = VehicleType.MOTORCYCLE;
						break;
					default:
						throw new InvalidSelectionException("Invalid vehicle selection");
					}
			}
			catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a number.");
				sc.next(); // Clears invalid input
			}
		}
			
		// Carpool
		Boolean carpool = null;
		while (carpool == null) {
			try {
				System.out.println("Carpool? (Y/N): ");
				String carpoolInput = sc.next();
					
				if (carpoolInput.equalsIgnoreCase("Y")) {
					carpool = true;
				}
				else if (carpoolInput.equalsIgnoreCase("N")) {
					carpool = false;
				}
				else {
					System.out.println("Invalid input. Enter Y or N.");
				}
			}
			catch (Exception e) {
				System.out.println("Invalid input. Please try again.");
			}
		}
		
			
		// Months
		int months = 0;
		while (months < 1 || months > 12) {
			try {
				System.out.println("Months (1-12): ");
				months = sc.nextInt();
				if (months < 1 || months > 12 ) {
					System.out.println("Invalid input. Enter a number between and 1 and 12.");
				}
			}
			catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a number.");
				sc.next(); // Clears invalid input
			}
		}
			 
		// Create selection
		PermitSelection selection = new PermitSelection(permit, vehicle, carpool, months);
					
		// Calculations
		PricingCalculator calculator = new PricingCalculator();
		calculator.calculate(selection);
			
		// Create and display receipt
		Receipt receipt = new Receipt();
		receipt.display(selection, calculator.getBaseMonthly(), calculator.getVehicleRate(), calculator.getMonthly(), 
				calculator.getSubTotal(), calculator.getTotal());
		}
	
}
