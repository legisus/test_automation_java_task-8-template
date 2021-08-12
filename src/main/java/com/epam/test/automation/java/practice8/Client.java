package com.epam.test.automation.java.practice8;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * <summary>
 * Implement class according to description of task.
 * </summary>
 */
public class Client implements Iterable<Deposit> {
    private Deposit[] deposits;

    public Client() {
        this.deposits = new Deposit[10];
    }

    public boolean addDeposit(Deposit deposit) {
        for (int i = 0; i < deposits.length; i++) {
            if (deposits[i] == null) {
                deposits[i] = deposit;
                return true;
            }
        }

        return false;
    }

    public BigDecimal totalIncome() {
        BigDecimal sumIncome = BigDecimal.ZERO;

        for (int i = 0; i < deposits.length; i++) {
            if (deposits[i] == null) {
                return sumIncome;
            }
            sumIncome = sumIncome.add(deposits[i].income());
        }
        return sumIncome.setScale(2, RoundingMode.HALF_EVEN);
    }

    public BigDecimal maxIncome() {
        if (deposits[0] == null) {
            return BigDecimal.ZERO;
        }
        BigDecimal maxIncome = deposits[0].income();

        for (int i = 1; i < deposits.length; i++) {
            if (deposits[i] != null) {
                if (maxIncome.compareTo(deposits[i].income()) < 0) {
                    maxIncome = deposits[i].income();
                }
            }
        }
        return maxIncome.setScale(2, RoundingMode.HALF_EVEN);
    }

    public BigDecimal getIncomeByNumber(int number) {
        return deposits[number] == null ? BigDecimal.valueOf(0) : deposits[number].income();
    }

    public Deposit[] sortDeposits() {
        int count = 0;
        for (Deposit deposit : deposits) {
            if (deposit != null) {
                count++;
            }
        }

        Deposit[] sorted = new Deposit[count];
        int index = 0;
        for (Deposit deposit : sorted) {
            if (deposit != null) {
               sorted[index] = deposit;
               index++;
            }
        }


        Arrays.sort(sorted, Comparator.reverseOrder());
        return sorted;
    }

    public int countPossibleToProlongDeposit() {
        int prolonged = 0;
        for (int i = 0; i < deposits.length; i++) {
            if (deposits[i] != null) {
                if (deposits[i].canToProlong()) {
                    ++prolonged;
                }
            }
        }
        return prolonged;
    }

    @Override
    public Iterator<Deposit> iterator() {
        return new Iterator<Deposit>() {

            private int cursor = 0;

            @Override
            public boolean hasNext() {
                if (cursor > deposits.length) {
                    return false;
                }

                return deposits[cursor] != null;
            }

            @Override
            public Deposit next() {
                Deposit deposit = deposits[cursor];
                ++cursor;
                return deposit;
            }
        };
    }

}
