package com.thoughtworks.tddintro.accountbalance;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTests {

    private Account account;

    @Before
    public void setUp() {
        account = new Account(100);
    }

    @Test
    public void shouldIncreaseMyBalanceWhenIDepositMoney() {
        assertThat(account.depositMoney(50), is(150));
    }

    @Test
    public void shouldDecreaseMyBalanceWhenIWithdrawMoney() {
        assertThat(account.withdrawMoney(50), is(50));
    }

    @Test
    public void shouldNotDecreaseMyBalanceWhenIWithdrawMoneyAndDoNotHaveEnoughToCoverTheWithdrawal() {
        assertThat(account.withdrawMoney(150), is(100));

    }
}
