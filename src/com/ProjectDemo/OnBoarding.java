/*package com.ProjectDemo;

import java.util.*;

import static com.ProjectDemo.Login.loginUser;
import static com.ProjectDemo.Register.registerUser;

public class OnBoarding {

    public static void onboarding() {

        Scanner userInput = new Scanner(System.in);

        while(isRunning) {
            System.out.println("1.Register\n2.Login");
            String ans = new BufferedReader(new InputStreamReader(System.in));
            switch (ans) {
                case "0" -> isRunning = false;
                case "1" -> registerUser(userInput);//
                case "2" -> {
                    loginUser(userInput);
                    isRunning = false;
                }
            }

        }
        System.out.println("1.Play \n2.Logout");
            String ans = userInput.nextLine();
            switch (ans) {
                case "1" -> System.out.println("let's get it!");
                case "2" -> System.exit(0);
            }

    }

}
*/