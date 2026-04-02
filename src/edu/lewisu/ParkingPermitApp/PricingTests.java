package edu.lewisu.ParkingPermitApp;

// Used AI to help with unit testing, walked through the steps to learn about the process and observe what it's doing

import java.math.BigDecimal;

public class PricingTests {

    public static void main(String[] args) {
        testResidentBasePrice();
        testCommuterBasePrice();
        testSUVModifier();
        testCarpoolDiscount();
        testPermitValidation();
        System.out.println("All tests finished.");
    }

    static void testResidentBasePrice() {
        ResidentPricingStrategy strategy = new ResidentPricingStrategy(); // Creates ResidentPricingStrategy object
        PermitSelection sel = new PermitSelection(PermitType.RESIDENT, VehicleType.CAR, false, 1); // Creates Minimal PermitSelection
        BigDecimal expected = new BigDecimal("45"); // Expected value
        BigDecimal actual = strategy.computeMonthly(sel); // Calls computeMonthly, this is what we're testing

        if (expected.compareTo(actual) != 0) { // Check if expected value and actual value match
            System.out.println("FAIL: Resident base price expected " + expected + " got " + actual); // Print FAIL and their differences if not same
        } else {
            System.out.println("PASS: Resident base price"); // Print PASS if same
        }
    }

    // Same steps as the test above, checks Commuter base rate logic this time
    static void testCommuterBasePrice() {
        CommuterPricingStrategy strategy = new CommuterPricingStrategy();
        PermitSelection sel = new PermitSelection(PermitType.COMMUTER, VehicleType.CAR, false, 1);
        BigDecimal expected = new BigDecimal("50").multiply(new BigDecimal("0.85"));
        BigDecimal actual = strategy.computeMonthly(sel);

        if (expected.compareTo(actual) != 0) {
            System.out.println("FAIL: Commuter base price expected " + expected + " got " + actual);
        } else {
            System.out.println("PASS: Commuter base price");
        }
    }

    // Test SUV rate modifier
    static void testSUVModifier() {
        BigDecimal base = new BigDecimal("45");
        BigDecimal expected = base.multiply(new BigDecimal("1.15"));
        BigDecimal actual = VehicleType.SUV.apply(base);

        if (expected.compareTo(actual) != 0) {
            System.out.println("FAIL: SUV modifier expected " + expected + " got " + actual);
        } else {
            System.out.println("PASS: SUV modifier");
        }
    }

    // Test CarpoolDiscount
    static void testCarpoolDiscount() {
        BigDecimal monthly = new BigDecimal("34.21");
        BigDecimal expected = monthly.multiply(new BigDecimal("0.90"));
        BigDecimal actual = new CarpoolDiscount().apply(monthly);

        if (expected.compareTo(actual) != 0) {
            System.out.println("FAIL: Carpool discount expected " + expected + " got " + actual);
        } else {
            System.out.println("PASS: Carpool discount");
        }
    }

    // Tests validation logic
    static void testPermitValidation() {
        PermitSelection sel = new PermitSelection(PermitType.RESIDENT, VehicleType.CAR, false, 0); // Create selection with bad data
        try {
            sel.validate();
            System.out.println("FAIL: Permit validation should have thrown exception"); // FAIL if it doesn't catch the bad data
        } catch (InvalidSelectionException e) {
            System.out.println("PASS: Permit validation throws exception for invalid months"); // PASS if it catches an exception
        }
    }
}