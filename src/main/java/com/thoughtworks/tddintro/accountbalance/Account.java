package com.thoughtworks.tddintro.accountbalance;

/**
 * Created by sarapiette on 7/25/16.
 */
public class Account {
    private int balance;
    public Account(int i) {
        balance = i;
    }

    public int depositMoney(int i) {
        balance += i;
        return balance;
    }
}
