package edu.lewisu.ParkingPermitApp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ParkingPermitApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		// Welcome message
        System.out.println("  -------------------------------------");
		System.out.println("-|* Welcome to the Parking Permit App *|-");
		System.out.println("  -------------------------------------");

        // Permit type menu
        PermitType permit = null;
        while (permit == null) {
            try {
                System.out.println("Permit type -");
                PermitType[] permitTypes = PermitType.values();
                for (int i = 0; i < permitTypes.length; i++) {
                    System.out.println((i + 1) + ") " + permitTypes[i].getDisplayName());
                }
                System.out.println("Select option: ");
                int permitChoice = sc.nextInt();

                if (permitChoice < 1 || permitChoice > permitTypes.length) {
                    System.out.println("Choice must be between 1 and " + permitTypes.length + ".");
                } else {
                    permit = permitTypes[permitChoice - 1];
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
            }
        }

        // Vehicle type menu
        VehicleType vehicle = null;
        while (vehicle == null) {
            try {
                System.out.println("\nVehicle type -");
                VehicleType[] vehicleTypes = VehicleType.values();
                for (int i = 0; i < vehicleTypes.length; i++) {
                    System.out.println((i + 1) + ") " + vehicleTypes[i].getDisplayName());
                }
                System.out.println("Select option: ");
                int vehicleChoice = sc.nextInt();

                if (vehicleChoice < 1 || vehicleChoice > vehicleTypes.length) {
                    throw new InvalidSelectionException("Invalid vehicle selection");
                } else {
                    vehicle = vehicleTypes[vehicleChoice - 1];
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
            }
            catch (InvalidSelectionException e) {
                System.out.println("Choice must be between 1 and " + VehicleType.values().length + ".");
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
        calculator.validate();
			
		// Create and display receipt
		Receipt receipt = new Receipt();
		receipt.display(selection, calculator.getBaseMonthly(), calculator.getVehicleRate(), calculator.getMonthly(), 
				calculator.getSubTotal(), calculator.getTotal());

        sc.close();
    }
	
}
