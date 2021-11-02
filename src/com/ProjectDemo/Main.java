package com.ProjectDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<User> users = new ArrayList<>();

        Scanner userInput = new Scanner(System.in);
        while(true) {
            System.out.println("1.Register\n2.Login\n3.Show User");
            String ans = userInput.nextLine();
            if (ans.equals("1")) {
                System.out.println("Enter Your Username:");
                String username = userInput.nextLine();
                System.out.println("Enter a password:");
                String password = userInput.nextLine();

                User user1 = new User(username, password);
                users.add(user1);
            }
            if(ans.equals("2")){
                System.out.println("Enter Your Username:");
                String checkName = userInput.nextLine();
                System.out.println("Enter a password:");
                String checkPass = userInput.nextLine();

                if(users.contains(checkName) && users.contains(checkPass)){
                    System.out.println("you are verified");
                }
                else{
                    System.out.println("You are not verified");
                }
            }
            if(ans.equals("3")){
                Iterator itr = users.iterator();
                while (itr.hasNext()){
                    User u =(User) itr.next();
                    System.out.println("username:"+u.getUsername()+"\nPassword:"+u.getPassword());
                }
            }
            if (ans.equals("0")) break;
        }
    }
}
