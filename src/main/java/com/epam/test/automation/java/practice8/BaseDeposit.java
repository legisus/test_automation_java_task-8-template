package com.epam.test.automation.java.practice8;

import java.math.BigDecimal;

/**
 * <summary>
 * Implement class according to description of task.
 * </summary>
 */
public class BaseDeposit extends Deposit{
    public BaseDeposit(BigDecimal amount, int period) {
        super(amount, period);

    }

    @Override
    public BigDecimal income() {
        BigDecimal percent = new BigDecimal("0.05");
        BigDecimal sum = amount;

        for (int i = 1; i <= period; i++) {
            sum = sum.add(sum.multiply(percent));
        }

        return sum.subtract(amount);
    }

}
