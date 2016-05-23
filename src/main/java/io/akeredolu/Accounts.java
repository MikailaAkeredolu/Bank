package io.akeredolu;
import java.util.ArrayList;


/**
 * Created by mikailaakeredolu on 5/18/16.
 */

public class Accounts extends Transactions{

    private AccountTypes accountType;
    private long accountNumber;
    private  String accountHoldersName;
    private OverDraft checkOverdraft;
    private double interestRate = 10.0;
    private double balance;
    private  double debit;
    private double credit;
    private Status status;

    //constructor to create a bank account with
    //no need to include account number and type in constructor

    public Accounts(long accountNumber){
        this.accountNumber = accountNumber;
        this.balance = 0.00;
        this.status = Status.OPEN;
    }

    //Constructor used for testing

    public Accounts(long accN,String achName, AccountTypes accType, Status status, double bal, OverDraft ovD){
        this.accountNumber = accN;
        this.accountHoldersName = achName;
        this.status = status;
        this.balance = bal;
        this.accountType = accType;
        this.checkOverdraft = ovD;
    }

    //to other accounts
    ArrayList<Transactions> recordOfTransactions = new ArrayList<Transactions>();

    public void addTransactions(Accounts sourceA, Accounts sourceB, String transType,double transA){

        recordOfTransactions.add(new Transactions(sourceA,sourceB,transType,transA));
    }

    public void printTransactionHistory(){
        for(int t = this.recordOfTransactions.size() -1 ; t>=0; t--){
            System.out.println(this.recordOfTransactions.get(t).toString());
           // System.out.println(recordOfTransactions);
        }

        //System.out.println(recordOfTransactions);
    }



    //Cash
    public void addTransactions(Accounts sourceA, String transType,double transA){

        recordOfTransactions.add(new Transactions(sourceA,transType,transA));
    }


    public String transferFunds(Accounts accountObjectDestination, double amount){
        if((accountHoldersName == accountObjectDestination.accountHoldersName )  && (amount < balance) && (accountObjectDestination.status == Status.FROZEN)){
            this.deductDebitFromAccount(amount);
            accountObjectDestination.addCreditToAccount(amount);
            return "Transaction was successful!";
        }else{
            return "Transaction was declined";
        }

    }


    //Methods

    public double getBalance()
    {
        if(status != Status.OPEN){
            System.out.println("This is NOT an active account");
            return 0;
        }
        return balance;

    }


    public double deductDebitFromAccount(double removeMoney){
        if(status == Status.OPEN){
            balance =  balance - removeMoney;
            //Accounts sourceA, String typeOfTransAcc,double transAmount
            addTransactions(this, "Debit",removeMoney);
            approvalStatus();
            return balance;
        }else {
            denialStatus();
        }
        return balance;
    }

    public double addCreditToAccount(double addMoney){
        if(status == Status.OPEN){
            balance = balance + addMoney;
            addTransactions(this, "Credit",addMoney);
            approvalStatus();
            return balance;
        }else {
            denialStatus();
        }
        return balance;
    }

    public void approvalStatus(){
        System.out.println("Transaction Approved!");
    }

    public void denialStatus(){
        System.out.println("Transaction Declined!");
    }

    public String changeAccountHoldersname(String changeName){
        if(status != Status.CLOSED){
            accountHoldersName = changeName;
            return accountHoldersName;
        }
        return "Sorry this is not an active account";
    }

    public Status reOpenAccount(Status accountStatus){

        if (accountStatus == Status.FROZEN || accountStatus == Status.OPEN){
            return Status.OPEN;
        }else{
            return Status.CLOSED;
        }
    }

    public Status closeAccount(){
        if (balance <= 0 ){
            return Status.CLOSED;
        }else
            return reOpenAccount(Status.FROZEN);
    }

    public double overDraw(OverDraft choice, double debitAmount){
        if(choice == OverDraft.ENABLED && debitAmount > balance){
            denialStatus();
            return balance;
        }else if(choice == OverDraft.ENABLED || choice == OverDraft.AUTOMATIC && debitAmount < balance){
            return balance = balance - debitAmount;
        }else{
            return balance;
        }
    }

    public double calculateInterest(){
        balance = balance * interestRate;
        return  balance;
    }

    //Getters and Setters
    public AccountTypes getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountTypes accountType) {
        this.accountType = accountType;
    }

    public OverDraft getOverDraft() {

        return checkOverdraft;
    }

    public void setOverDraft(OverDraft overDraft) {
        this.checkOverdraft = overDraft;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getAccountHoldersName() {
        return accountHoldersName;
    }

    public void setAccountHoldersName(String accountHoldersName) {
        this.accountHoldersName = accountHoldersName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

}
