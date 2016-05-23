package io.akeredolu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by mikailaakeredolu on 5/19/16.
 */
public class Users  {

    private String username;
    private String userPassword;
   // private long accountNumber = 2000;
   // AccountTypes typeofAccNeeded;

    public Users(String username, String userPassword){
        this.username = username;
        this.userPassword = userPassword;
    }

    //HasMap

    Map<String, Map<Long,Accounts>>userBankAccounts = new HashMap<String, Map<Long, Accounts>>(); //checkins/savings

    Map<Long,Accounts>userAccounts = new HashMap<Long,Accounts>();  //associate account with account number

    public void addCheckingAccount(long accountNumber){
        userAccounts.put(accountNumber,new Checking(accountNumber)); //inner
        userBankAccounts.put("Checking", userAccounts); //outter
    }


    public void addSavingsAccount(long accountNumber){
        userAccounts.put(accountNumber,new Savings(accountNumber));
        userBankAccounts.put("Savings", userAccounts);
    }
    public void addInvestmentAccount(long accountNumber){
        userAccounts.put(accountNumber,new Investments(accountNumber));
        userBankAccounts.put("Investment", userAccounts);
    }

    public Accounts getUserCheckingsAccount(long accountNumber){
        return userBankAccounts.get("Checking").get(accountNumber);
    }

    public Accounts getUserSavingsAccount(long accountNumber){
        return userBankAccounts.get("Savings").get(accountNumber);
    }
    public Accounts getUserInvestmentAccount(long accountNumber){
        return userBankAccounts.get("Investment").get(accountNumber);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

}
