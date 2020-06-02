package tests;

import BankAccount.BankAccount;
import org.junit.Assert;
import org.junit.Test;

public class BankAccountTests {

    @Test
    public void depositAmount(){

        BankAccount ba = new BankAccount();

        ba.deposit(20);
        Assert.assertTrue(ba.getBalance() == 20);
    }

    @Test
    public void withDrawAmount() {
        BankAccount ba = new BankAccount();

        ba.deposit(20);
        ba.withDraw(10);
        Assert.assertTrue(ba.getBalance() == 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void withDrawNegativeAmount() {
        BankAccount ba = new BankAccount();

        ba.deposit(20);
        ba.withDraw(10);

    }


}
