package io.akeredolu;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by mikailaakeredolu on 5/18/16.
 */
public class Transactions {

    private String transactionType;
    private double transactionAmount;
    private Accounts sourceAccount;
    private Accounts destinationAccount;

    private Date timeStamp;
    private static long uniqueFtnNumber;

    public Transactions(){}

    //to other accounts

    public Transactions(Accounts sourceA, Accounts destinationA, String typeOfTransAcc,double transAmount){
        this.transactionType = typeOfTransAcc;
        this.transactionAmount = transAmount;
        this.sourceAccount = sourceA;
        this.destinationAccount = destinationA;
        this.timeStamp = new Date();
        uniqueFtnNumber++;

    }



    public Transactions(Accounts sourceA, String typeOfTransAcc,double transAmount){
        this.transactionType = typeOfTransAcc;
        this.transactionAmount = transAmount;
        this.sourceAccount = sourceA;
        this.destinationAccount = null;
        this.timeStamp = new Date();
        uniqueFtnNumber++;

    }


    @Override
    public String toString() {
        return "Transactions{" +
                "transactionType='" + transactionType + '\'' +
                ", transactionAmount=" + transactionAmount +
                ", sourceAccount=" + sourceAccount +
                ", destinationAccount=" + destinationAccount +
                ", timeStamp=" + timeStamp +
                '}';
    }

    //TimeStamp Getter
    public Date getTimeStamp() {
        return timeStamp;
    }

    public static long getUniqueFtnNumber() {
        return uniqueFtnNumber;
    }
}
