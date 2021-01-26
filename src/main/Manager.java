package main;

import java.util.Date;
import java.util.ArrayList;

public class Manager extends User {

    public Manager(String firstName, String lastName, String phoneNumber, String username,
    String password, AccessLevel accessLevel, Date registrationDate, Date lastLoginDate){

        super(firstName, lastName, phoneNumber, username, password, accessLevel, registrationDate, lastLoginDate);
    }

    public ActionResult register (User user){
        
        short userslenght = users.size();

        users.add(user);

        if(users.size() == userslenght + 1){
            return ActionResult.SUCCESS;
        }else{
            return ActionResult.UNKNOWN_ERROR;
        }
    }

    public ActionResult edit (String username){

    }

    public ActionResult remove (String username){

    }
}
