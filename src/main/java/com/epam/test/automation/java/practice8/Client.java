package com.epam.test.automation.java.practice8;

import java.math.BigDecimal;
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

    public boolean addDeposit (Deposit deposit){
        for (int i = 0; i < deposits.length; i++) {
            if(deposits[i] == null){
                deposits[i] = deposit;
                return true;
            }
        }

        return false;
    }

    public BigDecimal totalIncome(){
        BigDecimal sumIncome = BigDecimal.ZERO;

        for (int i = 0; i < deposits.length; i++) {
            if(deposits[i] == null){
                return sumIncome;
            }
            sumIncome = sumIncome.add(deposits[i].income());
        }
        return sumIncome.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal maxIncome(){
        if (deposits[0] == null){
            return BigDecimal.ZERO;
        }
        BigDecimal maxIncome = deposits[0].income();

        for (int i = 1; i < deposits.length; i++) {
            if(deposits[i] != null){
                if (maxIncome.compareTo(deposits[i].income()) < 0){
                    maxIncome = deposits[i].income();
                }
            }
        }
        return maxIncome;
    }

    public BigDecimal getIncomeByNumber (int number){
        return deposits[number] == null ? BigDecimal.valueOf(0) : deposits[number].income();
    }

    public Deposit[] sortDeposits(){
        Deposit[] sorted = deposits.clone();
        Arrays.sort(sorted, Comparator.reverseOrder());
        return sorted;
    }

    public int countPossibleToProlongDeposit(){
        int prolonged = 0;
        for (int i = 0; i < deposits.length; i++) {
            if(deposits[i] != null){
                if (deposits[i].canToProlong()){
                    prolonged++;
                }
            }
        }
        return prolonged;
    }

    @Override
    public Iterator<Deposit> iterator() {

        return null;
    }

    @Override
    public void forEach(Consumer<? super Deposit> action) {

    }

    @Override
    public Spliterator<Deposit> spliterator() {
        return null;
    }
}
