package com.ProjectDemo;

import java.util.Scanner;

public class Register {

    public static void registerUser(Scanner userInput) {
        while(true){
        System.out.println("Enter Your Username:");
        String username = userInput.nextLine();
        System.out.println("Enter a password:");
        String password = userInput.nextLine();
        if(StoreData.getInstance().getUser(username) != null){
            System.out.println("This username is already taken.");
        }
        else{
            User user1 = new User(username, password);
            StoreData.getInstance().addUser(user1.getUsername(), user1);
            System.out.println("Registration Completed!");
            break;
        }
    }
}
}
