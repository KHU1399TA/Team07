package main;

import java.util.Date;
import java.util.ArrayList;

public abstract class User {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String username;
    private String password;
    private AccessLevel accessLevel;
    private Date registrationDate;
    private Date lastLoginDate;

    public User(String firstName, String lastName, String phoneNumber, String username, String password,
            AccessLevel accessLevel, Date registrationDate, Date lastLoginDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.accessLevel = accessLevel;
        this.registrationDate = registrationDate;
        this.lastLoginDate = lastLoginDate;
    }

    public ActionResult login(String username, String password) {

        boolean user = true;
        boolean pass = true;

        m:for (int i = 0; i < users.size(); i++) {

            if (users.get(i).username.equals(username)){
                 
                for (int j = 0; j < users.size(); j++){

                    if (users.get(i).password.equals(password)){

                        return ActionResult.SUCCESS;
                        pass = false;
                        break m;
                    }
                }
                
            return ActionResult.INVALID_PASSWORD;
            user = false;
            break m;
            }
        }

        if(pass & user)return ActionResult.INVALID_USERNAME;
    }
}
