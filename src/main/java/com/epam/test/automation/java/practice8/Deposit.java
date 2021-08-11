package com.epam.test.automation.java.practice8;

import java.math.BigDecimal;

/**
 * <summary>
 * Implement class according to description of task.
 * </summary>
 */
public abstract class Deposit implements Prolongable, Comparable<Deposit>{
    public final BigDecimal amount;
    public final int period;

    public Deposit(BigDecimal amount, int period) {
        this.amount = amount;
        this.period = period;
    }

    public abstract BigDecimal income();

    @Override
    public boolean canToProlong() {
        return false;
    }
    @Override
    public int compareTo(Deposit deposit) {
       return income().add(amount).compareTo(deposit.income().add(deposit.amount));

    }
}
