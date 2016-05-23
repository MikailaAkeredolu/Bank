package io.akeredolu;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mikailaakeredolu on 5/19/16.
 */
public class UserAccountNanager {

    public static Map<Integer, Users> theBank = new HashMap<Integer, Users>();

    public static void addAccountToBank(int iD, Users user){
        theBank.put(iD,user);

    }

}


