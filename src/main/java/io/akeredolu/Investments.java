package io.akeredolu;

/**
 * Created by mikailaakeredolu on 5/18/16.
 */
public class Investments extends Accounts {
    private double interestRate = 5.0;
    public Investments(String nameOnInvestmentAccount){
        super(AccountTypes.INVESTMENT,nameOnInvestmentAccount);

    }
}
