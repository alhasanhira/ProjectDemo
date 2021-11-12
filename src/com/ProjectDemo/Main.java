package com.ProjectDemo;

import java.util.*;

import static com.ProjectDemo.Login.loginUser;
import static com.ProjectDemo.Register.registerUser;

public class Main {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        boolean isRunning = true;
        while(isRunning) {
            System.out.println("1.Register\n2.Login");
            String ans = userInput.nextLine();
            switch (ans) {
                case "0" -> isRunning = false;
                case "1" -> registerUser(userInput);
                case "2" -> loginUser(userInput);
            }
        }
    }

}
