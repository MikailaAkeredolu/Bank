package io.akeredolu;
import java.util.ArrayList;

/**
 * Created by mikailaakeredolu on 5/19/16.
 */
public class Users  {

    private String username;
    private String userPassword;

    public Users(String username, String userPassword){
        this.username = username;
        this.userPassword = userPassword;
    }

    ArrayList<Accounts> userAccountsList = new ArrayList<Accounts>();

    public void makeNewUserAccount(AccountTypes typeofAccNeeded, String nameOnAccount){
        if (typeofAccNeeded == AccountTypes.CHECKING){
            userAccountsList.add(new Checking(nameOnAccount));
        }else if(typeofAccNeeded == AccountTypes.SAVINGS){
            userAccountsList.add(new Savings(nameOnAccount));
        }else{
            userAccountsList.add(new Investments(nameOnAccount));
        }
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

    public ArrayList<Accounts> getUserAccountsList() {
        return userAccountsList;
    }

    public void setUserAccountsList(ArrayList<Accounts> userAccountsList) {
        this.userAccountsList = userAccountsList;
    }
}
