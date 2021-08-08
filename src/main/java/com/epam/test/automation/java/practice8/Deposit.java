package com.epam.test.automation.java.practice8;

import java.math.BigDecimal;

/**
 * <summary>
 * Implement class according to description of task.
 * </summary>
 */
public abstract class Deposit implements Comparable<Deposit>{
    public final BigDecimal amount;
    public final int period;

    public Deposit(BigDecimal amount, int period) {
        this.amount = amount;
        this.period = period;
    }

    public abstract BigDecimal income();
}
