# parking_permit
Parking permit app that performs various calculations for cost at a university.

## Design
I followed the suggested structure of the assignment, as well as adding classes CampusFee. I used Receipt as a printing class, so it is only usable within a console application. ParkingPermitApp functioned as my main. All printing was confined to ParkingPermitApp and Receipt, with ParkingPermitApp taking all the user input. I handled validating input until the user gives a valid input, although with more time I'd like to go back and see how I could do that cleaner.

At this time, I hard-coded the menus in ParkingPermitApp for the sake of time. I plan to go back and and fix this so that it holds up better to updates and changes.

I used RateModifier as an interface to enforce the 'apply' method on CampusFee, CarpoolDiscount, VehicleType.

PricingPipeline was used to hold a list of a transaction's modifiers of type RateModifiers and apply them.

When I go back and refactor this code, I want to see where I could implement Validatable more, as I feel like it fell to the back of my mind.

If we went over unit testing in class, I believe it was one of the days I missed. I employed AI to help me run these tests as this was new to me. Exemplified polymorphism in these tests, as both testResidentBasePrice, testCommuterBasePrice, and testSUVMoidifer implement RateModifier.
