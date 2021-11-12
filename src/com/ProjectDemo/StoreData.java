package com.ProjectDemo;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StoreData {
    private static Object monitor = new Object();
    private static StoreData mInstance;
    private final Map<String, User> userMap ;

    private StoreData() {
        userMap = new ConcurrentHashMap<>();
    }

    public static StoreData getInstance() {
        if (mInstance == null){
            synchronized (monitor){
                if(mInstance == null)
                    mInstance = new StoreData();
            }
        }
        return mInstance;
    }

    // retrieve array from anywhere
    public User getUser(String key) {
        return this.userMap.get(key);
    }
    //Add element to array
    public void addUser(String key,User value) {
        userMap.put(key,value);
    }

    public int getSize(){
        return this.userMap.size();
    }


    public List<User> getAllUsers() {
        return new ArrayList<>(this.userMap.values());
    }


}
