package com.ProjectDemo;

import java.util.Scanner;

public class Login {

    public static void loginUser(Scanner userInput) {
        System.out.println("Enter Your ID:");
        String checkName = userInput.nextLine();
        System.out.println("Enter Your Password:");
        String checkPass = userInput.nextLine();
        boolean isVerified = false;
        User user = StoreData.getInstance().getUser(checkName);
        if (user != null && user.getPassword().equals(checkPass))
            isVerified = true;

        if (isVerified) {
            System.out.println("you are verified");

        } else {
            System.out.println("You are not verified");
        }
    }
}
