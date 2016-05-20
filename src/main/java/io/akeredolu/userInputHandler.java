package io.akeredolu;

import java.util.Scanner;

/**
 * Created by mikailaakeredolu on 5/19/16.
 */
public class userInputHandler {

    userAccountManager uam = new userAccountManager();

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

    public static void promptUser(String msg){
        System.out.println(msg);

    }




    public void engine(){
        String storage = "";
        boolean flag = true;
        while(flag){
            promptUser("Welcome to the Wu Tang Forever Bank!!!");
            int choice = promptForIntValue("Press 1 to create an account\n Press 2 to log into your account\n");
            switch (choice){
                case 1:
                   uam.makeUsernameandPassword(promptUserForString("Please enter username"),promptUserForString("Please enter password"));
                    promptUser("You have created a wu tang account son!");
                    System.out.println();
                    break;
                case 2:
                    uam.logIN(promptUserForString("Please enter password"));
            }
        }

    }



}
