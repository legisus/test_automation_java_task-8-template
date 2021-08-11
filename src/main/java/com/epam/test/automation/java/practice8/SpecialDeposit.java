package com.epam.test.automation.java.practice8;

import java.math.BigDecimal;

/**
 * <summary>
 * Implement class according to description of task.
 * </summary>
 */
public class SpecialDeposit extends Deposit{
    private final BigDecimal onePercent = new BigDecimal("0.01");
    private final BigDecimal oneThousandUah = new BigDecimal("1000");

    public SpecialDeposit(BigDecimal amount, int period) {
        super(amount, period);
    }

    @Override
    public BigDecimal income() {
        BigDecimal percent = onePercent;
        BigDecimal sum = amount;

        for (int i = 1; i <= period; i++) {
            sum = sum.add(sum.multiply(percent));
            percent = percent.add(onePercent);
        }

        return sum.subtract(amount);
    }

    @Override
    public boolean canToProlong() {
        return amount.compareTo(oneThousandUah) >= 0;
    }


}
