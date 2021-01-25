package main;

public class Manager extends User {

    public Manager(String firstName, String lastName, String phoneNumber, String username,
    String password, AccessLevel accessLevel, Date registrationDate, Date lastLoginDate){

        super(firstName, lastName, phoneNumber, username, password, accessLevel, registrationDate, lastLoginDate);
    }

    public ActionResult register (User user){

        
    }

    public ActionResult edit (String username){

    }

    public ActionResult remove (String username){

    }
}
