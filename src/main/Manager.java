package main;

import java.util.*;

public class Manager extends User {

    public Manager(String firstName, String lastName, String phoneNumber,
            String username, String password, AccessLevel accessLevel,
            Date registrationDate, Date lastLoginDate) {

        super(firstName, lastName, phoneNumber, username, password, accessLevel,
                registrationDate, lastLoginDate);
    }
}