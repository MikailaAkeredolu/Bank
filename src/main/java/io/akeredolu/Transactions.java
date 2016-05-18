package io.akeredolu;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by mikailaakeredolu on 5/18/16.
 */
public class Transactions {

    private AccountTypes transactionType;
    private double transactionAmount;
    private Accounts sourceAccount;
    private Accounts destinationAccount;

    private Date timeStamp;
    private static long uniqueFtnNumber;

    public Transactions(){}

    public Transactions(Accounts sourceA, Accounts destinationA, AccountTypes typeOfTransAcc,double transAmount){
        this.transactionType = typeOfTransAcc;
        this.transactionAmount = transAmount;
        this.sourceAccount = sourceA;
        this.destinationAccount = destinationA;
        this.timeStamp = new Date();
        uniqueFtnNumber++;

    }


    /*

     //Transactions stuff
    private AccountTypes transactionType;
    private double transactionAmount;
    private Accounts sourceAccount;
    private Accounts destinationAccount;
    private Date timeStamp;
    private static long uniqueFtnNumber;

    //TimeStamp Getter
    public Date getTimeStamp() {
        return timeStamp;
    }
     */


    //TimeStamp Getter
    public Date getTimeStamp() {
        return timeStamp;
    }
}
