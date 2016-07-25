package com.thoughtworks.tddintro.accountbalance;

/**
 * Created by sarapiette on 7/25/16.
 */
public class Account {
    private int balance;

    public Account(int i) {
        balance = i;
    }

    public void depositMoney(int i) {
        balance += i;
    }

    public void withdrawMoney(int i) {
        if(i <= balance)
            balance -=i;
    }

    public int getBalance() {
        return balance;
    }
}
