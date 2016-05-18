package io.akeredolu;
import org.junit.Assert;
import org.junit.Test;
/**
 * Created by mikailaakeredolu on 5/18/16.
 */
public class AccountsTest {

    @Test
    public void getBalanceTestOPEN(){
        Accounts testAccount1 = new Accounts(1,"Mike",AccountTypes.CHECKING,Status.OPEN,100.0, OverDraft.AUTOMATIC);
        double expectedValue = testAccount1.getBalance();
        double actualValue = 100.0;
        Assert.assertEquals(expectedValue,actualValue,.01);
    }

    @Test
    public void getBalanceTestClosed(){
        Accounts testAccount2 = new Accounts(2,"Jones",AccountTypes.SAVINGS,Status.CLOSED,100.0, OverDraft.AUTOMATIC);
        double expectedValue = testAccount2.getBalance();
        double actualValue = 0;
        Assert.assertEquals(expectedValue,actualValue,.01);
    }

    @Test
    public void getBalanceTestFrozen(){
        Accounts testAccount3 = new Accounts(3,"Christopher Wallace",AccountTypes.INVESTMENT,Status.FROZEN,100.0, OverDraft.ENABLED);
        double expectedValue = testAccount3.getBalance();
        double actualValue = 0;
        Assert.assertEquals(expectedValue,actualValue,.01);
    }

    @Test
    public void deductDebitFromAccountTest(){
        Accounts testAccount4 = new Accounts(4,"Bobby Digital",AccountTypes.CHECKING,Status.OPEN,100.0, OverDraft.AUTOMATIC);
        double expectedValue = testAccount4.deductDebitFromAccount(20.0);
        double actualValue = 80.0;
        Assert.assertEquals(expectedValue,actualValue,.01);
    }

    @Test
    public void addCreditToAccountTest(){
        Accounts testAccount5 = new Accounts(5,"Jack Johnson",AccountTypes.CHECKING,Status.OPEN,100.0, OverDraft.AUTOMATIC);
        double expectedValue = testAccount5.addCreditToAccount(30.0);
        double actualValue = 130.0;
        Assert.assertEquals(expectedValue,actualValue,.01);
    }

    @Test
    public void changeAccountHoldersnameTest(){
        Accounts testAccount6 = new Accounts(6,"lulu",AccountTypes.CHECKING,Status.OPEN,100.0, OverDraft.AUTOMATIC);
        String expectedValue = testAccount6.changeAccountHoldersname("Rza");
        String actualValue = "Rza";
        Assert.assertEquals("The name should now be Rza",expectedValue,actualValue);
    }

    @Test
    public void reOpenAccountTest(){
        Accounts testAccount7 = new Accounts(7,"Black Johnson",AccountTypes.CHECKING,Status.FROZEN,100.0, OverDraft.DISABLED);
        Status expectedValue = testAccount7.reOpenAccount(Status.FROZEN);
        Status actualValue = Status.OPEN;
        Assert.assertEquals(expectedValue,actualValue);
    }

    @Test
    public void closeAccountTest(){
        Accounts testAccount8 = new Accounts(8,"OG Bobby Johnson",AccountTypes.CHECKING,Status.OPEN,0.0, OverDraft.AUTOMATIC);
        Status expectedValue = testAccount8.closeAccount();
        Status actualValue = Status.CLOSED;
        Assert.assertEquals(expectedValue,actualValue);

    }

    @Test
    public void overDrawTest(){
        Accounts testAccount9 = new Accounts(9,"OG Bobby Johnson",AccountTypes.CHECKING,Status.OPEN,0.1, OverDraft.AUTOMATIC);
        double expectedValue = testAccount9.overDraw(OverDraft.ENABLED,100.0);
        double actualValue = testAccount9.getBalance();
        Assert.assertEquals(expectedValue,actualValue,.01);

    }

    @Test
    public void interestRateTest(){
        Accounts testAccount10 = new Accounts(10,"OG Bobby Johnson",AccountTypes.CHECKING,Status.OPEN,100.0, OverDraft.AUTOMATIC);
        double expectedValue = testAccount10.calculateInterest();
        double actualValue = testAccount10.getBalance();
        Assert.assertEquals(expectedValue,actualValue,.01);
    }

    @Test
    public void transferFundTest(){
        Accounts testTransfer1 = new Accounts(11,"OG Bobby Johnson",AccountTypes.CHECKING,Status.OPEN,100.0, OverDraft.AUTOMATIC);
        Accounts testTransfer2 = new Accounts(12,"OG Bobby Johnson",AccountTypes.SAVINGS,Status.OPEN,50.0, OverDraft.AUTOMATIC);


    }


}
