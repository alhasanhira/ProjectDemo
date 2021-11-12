package com.ProjectDemo;

public class Utils {

    public static void printOutAllUsers() {
        if (StoreData.getInstance().getSize() == 0)
            System.out.println("There is no user");
        else {
            for(User u:StoreData.getInstance().getAllUsers()){
                System.out.println(u);
            }
        }
    }
}
