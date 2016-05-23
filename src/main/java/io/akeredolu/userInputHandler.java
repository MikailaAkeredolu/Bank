package io.akeredolu;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by mikailaakeredolu on 5/19/16.
 */
public class userInputHandler {

    Accounts currentAccountOnDisplay;
    int currentIDOnDisplay;
    boolean power = true;

   // UserAccountNanager uam = new UserAccountNanager();


    public static Scanner input = new Scanner(System.in);

    public static int promptForIntValue(String intMessage){
        promptUser(intMessage);
        return input.nextInt();
    }

    public static double promptUserForDouble(String stringMessage){
        promptUser(stringMessage);
        return input.nextDouble();
    }

    public  static String promptUserForString(String userString){
        promptUser(userString);
        return input.next();

    }
    public static long promptUserForLong(String userString){
        promptUser(userString);
        return input.nextLong();

    }

    public static void promptUser(String msg){
        System.out.println(msg);

    }

    public static void prompForAccount(){
        System.out.println();

    }

    public Accounts accessAccount(int accType,int userID ,long acNumber){
        Accounts account = null;

        switch (accType){
            case 1:
                account = UserAccountNanager.theBank.get(userID).getUserCheckingsAccount(acNumber);
                break;
            case 2:
                account = UserAccountNanager.theBank.get(userID).getUserSavingsAccount(acNumber);
                break;
            case 3:
                account = UserAccountNanager.theBank.get(userID).getUserInvestmentAccount(acNumber);
                break;
        }
        return account;
    }

    public void createAccounts(int uChoice, int userID){

        System.out.println("what do you want your bank account number to be?");

        long acNumber = input.nextLong();

        switch (uChoice){
            case 1:
                UserAccountNanager.theBank.get(userID).addCheckingAccount(acNumber);
                currentAccountOnDisplay = accessAccount(1,userID,acNumber);
                break;
            case 2:
                UserAccountNanager.theBank.get(userID).addSavingsAccount(acNumber);
                currentAccountOnDisplay = accessAccount(2,userID,acNumber);
                break;
            case 3:
                UserAccountNanager.theBank.get(userID).addInvestmentAccount(acNumber);
                currentAccountOnDisplay = accessAccount(3,userID,acNumber);
                break;
        }
    }



    public void createOrAccessUser() {

       // String storage = "";
       // boolean flag = true;
       // while (flag) {
            promptUser("Welcome to the Wu Tang Financial!!!");
            int choice = promptForIntValue("Press 1 to create a user\nPress 2 to log into your account");
            switch (choice) {
                case 1:
                    String name = promptUserForString("Please enter username");
                    String password = promptUserForString("Please enter password");
                    currentIDOnDisplay  = UserAccountNanager.theBank.size() + 1;
                    UserAccountNanager.addAccountToBank(currentIDOnDisplay,new Users(name, password));
                    System.out.println("hello your name is " + name +  " And your password is : " + password + " Your ID number is : " + currentIDOnDisplay);
                    int userChoice = promptForIntValue("Press 1 to create a checking\nPress 2 for savings,\n" +
                            "Press 3 for Investments ");
                    createAccounts(userChoice, currentIDOnDisplay);
                    break;
                case 2:
                    System.out.println();
                 currentIDOnDisplay =  promptForIntValue("Welcome back son. Enter your userID number");
                   String pword = promptUserForString("Now please Enter your password ");
                    String actualpassowrd = UserAccountNanager.theBank.get(currentIDOnDisplay).getUserPassword();

                    if(actualpassowrd.equals(pword)){
                    int userPrompt = promptForIntValue("enter 1) for Checking, 2) for Savings, 3) for Investments");
                    long banNumber = promptUserForLong("Enter your bank account number");
                     currentAccountOnDisplay =  accessAccount(userPrompt,currentIDOnDisplay,banNumber);
                    }else {
                        System.out.println("you entered the wrong information son");
                        //call to run the atm again
                        runTheATM();
                        break;
                    }
            }
        }
  //  }



    public void runTheATM(){
        //check for returning user
       createOrAccessUser();

        while(power){
       startAtm();
        }

    }


    public void startAtm(){
       int choice =  promptForIntValue("enter\n 1) to credit,\n 2) debit \n 3) checkBalance, \n4) Transfer Funds \n5) print transaction History ");
        menuhandler(choice);
    }

    public void menuhandler(int menuChoice){
        switch (menuChoice){
            case 1 :
                currentAccountOnDisplay.addCreditToAccount(promptUserForDouble("Enter the amount to credit"));
                System.out.println("Your balance is " + currentAccountOnDisplay.getBalance());
            break;
            case 2:
                currentAccountOnDisplay.deductDebitFromAccount(promptUserForDouble("Enter the amount to debit "));
                System.out.println("Your balance is " + currentAccountOnDisplay.getBalance());
            break;
            case 3:
                currentAccountOnDisplay.getBalance();
                System.out.println("Your balance is " + currentAccountOnDisplay.getBalance());
             break;
            case 4:
                try{
                Accounts accounts = accessAccount(promptForIntValue("What type of account 1) checking, 2) savings, 3) investments)"),promptForIntValue("what's the iD of the user to transfer funds to?"),promptUserForLong("Whats the account number to transfer funds to? "));
                currentAccountOnDisplay.transferFunds(accounts, promptUserForDouble("Enter the amount to transfer "));}
                catch (NullPointerException e){
                    System.out.println(" there is no account to transfer to");
                }
                break;
            case 5:
                currentAccountOnDisplay.printTransactionHistory();
                //loop through with array list and use tostring methodd
                break;
            case 6:
                currentAccountOnDisplay.closeAccount();
            default:
                System.out.println("You entered the wrong Information");
        }

    }

}
