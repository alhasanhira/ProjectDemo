package com.ProjectDemo;

import java.util.Scanner;

public class Register {

    public static void registerUser(Scanner userInput) {
        System.out.println("Enter Your Username:");
        String username = userInput.nextLine();
        System.out.println("Enter a password:");
        String password = userInput.nextLine();
        User user1 = new User(username, password);
        StoreData.getInstance().addUser(user1.getUsername(),user1);
    }
}
