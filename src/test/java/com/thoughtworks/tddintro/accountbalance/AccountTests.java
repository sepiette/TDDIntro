package com.thoughtworks.tddintro.accountbalance;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTests {

    private Account account;


    @Test
    public void shouldIncreaseMyBalanceWhenIDepositMoney() {
        account = new Account(100);
        account.depositMoney(50);
        assertThat(account.getBalance(), is(150));
    }

    @Test
    public void shouldDecreaseMyBalanceWhenIWithdrawMoney() {
        account = new Account(100);
        account.withdrawMoney(50);
        assertThat(account.getBalance(), is(50));
    }

    @Test
    public void shouldNotDecreaseMyBalanceWhenIWithdrawMoneyAndDoNotHaveEnoughToCoverTheWithdrawal() {
        account = new Account(50);
        account.withdrawMoney(100);
        assertThat(account.getBalance(), is(50));

    }
}
