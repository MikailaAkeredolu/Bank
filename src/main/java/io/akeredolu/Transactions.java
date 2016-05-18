package io.akeredolu;

/**
 * Created by mikailaakeredolu on 5/18/16.
 */
public class Transactions {

    private AccountTypes typeOfTransactionAccount;
    private double transactionAmount;
    String transactionAction;

    public Transactions(AccountTypes typeOfTransAcc, double transAmount,String transAction){
        this.typeOfTransactionAccount = typeOfTransAcc;
        this.transactionAmount = transAmount;
        this.transactionAction = transAction;
    }
}
