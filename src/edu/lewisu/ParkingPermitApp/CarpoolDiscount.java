package edu.lewisu.ParkingPermitApp;

import java.math.BigDecimal;

public class CarpoolDiscount implements RateModifier{

    private static final BigDecimal DISCOUNT = new BigDecimal("-0.1");

    public BigDecimal getCPDiscount() {
        return CarpoolDiscount.DISCOUNT;
    }

    @Override
    public BigDecimal apply(BigDecimal currentMonthly) {

        BigDecimal change = currentMonthly.multiply(DISCOUNT);
        return currentMonthly.add(change);
    }

}
