package main;

import java.util.Date;

public abstract class User {
    
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String username;
    private String password;
    private AccessLevel accessLevel;
    private Date registrationDate;
    private Date lastLoginDate;

    public User(String firstName, String lastName, String phoneNumber, String username,
     String password, AccessLevel accessLevel, Date registrationDate, Date lastLoginDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.accessLevel = accessLevel;
        this.registrationDate = registrationDate;
        this.lastLoginDate = lastLoginDate;
    }

    public ActionResult login (String username, String password){
        
        
    }
}
