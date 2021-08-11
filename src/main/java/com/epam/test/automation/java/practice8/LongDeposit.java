package com.epam.test.automation.java.practice8;

import java.math.BigDecimal;

/**
 * <summary>
 * Implement class according to description of task.
 * </summary>
 */
public class LongDeposit extends Deposit {
    public LongDeposit(BigDecimal amount, int period) {
        super(amount, period);
    }

    @Override
    public BigDecimal income() {
        BigDecimal percent = new BigDecimal("0.15");
        BigDecimal sum = amount;

        for (int i = 7; i <= period; i++) {
            sum = sum.add(sum.multiply(percent));
        }

        return sum.subtract(amount);
    }

    @Override
    public boolean canToProlong() {
        return period < period * 12 * 3;
    }

}
