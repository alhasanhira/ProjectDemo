package com.ProjectDemo;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean loginflag = false;
        Map<String,String> users = new Hashtable<>();

        Scanner userInput = new Scanner(System.in);

        while(!loginflag) {
            System.out.println("\n\nRIDDLARK\n\n1.Register\n2.Login\n3.Show User");
            String ans = userInput.nextLine();
            if (ans.equals("1")) {
                System.out.println("Enter Your Username:");
                String username = userInput.nextLine();

                if(users.containsKey(username)){
                    System.out.println("This username is already taken!");
                }

                else {
                    System.out.println("Enter a password:");
                    String password = userInput.nextLine();
                    users.put(username, password);
                    System.out.println("Registration Completed!");
                }
            }
            if(ans.equals("2")){
                System.out.println("Enter Your Username:");
                String checkName = userInput.nextLine();
                System.out.println("Enter a password:");
                String checkPass = userInput.nextLine();

                if(users.containsKey(checkName) && users.get(checkName).contentEquals(checkPass)){
                    System.out.println("you are verified");
                    loginflag = true;
                }
                else{
                    System.out.println("You are not verified");
                }
            }
            /*if(ans.equals("3")){
                for (Map.Entry<String, String> entry : users.entrySet()) {
                    System.out.println("username: " + entry.getKey() + "\npassword: " + entry.getValue());
                }
            }*/
            if (ans.equals("0")) break;
        }

        while(loginflag) {
            System.out.println("Press Enter key to continue...");
            try {
                System.in.read();
            }
            catch(Exception e)
            {}
            //need to add code here.
        }
    }
}
