package io.akeredolu;

import java.util.ArrayList;

/**
 * Created by mikailaakeredolu on 5/19/16.
 */
public class userAccountManager {

    private Users theCurrentUser;
    private boolean curretlyLoggedIn = false;

    ArrayList<Users>userAccounts = new ArrayList<Users>();

    public void makeUsernameandPassword(String uName, String uPword){
        if(checkifuserNameExist(uName)){
            System.out.println("UserName already exist");
        }else{userAccounts.add(new Users(uName,uPword));}
    }

    public boolean checkifuserNameExist(String userN){
        for(int x = 0; x < userAccounts.size(); x++){
            if(userAccounts.get(x).getUsername().equals(userN)){
                theCurrentUser = userAccounts.get(x);
                return  true;
            }

        }
      return false;
    }


    public boolean logIN(String uPword){
       if (theCurrentUser.getUserPassword().equals(uPword)){
           System.out.println("you are logged in!");
           curretlyLoggedIn = true;
       }
        return true;
    }

}
