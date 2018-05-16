package com.company;

import java.util.HashMap;
import java.util.Map;

public class UserStore {
    private Map<String, User> userStoreMap = new HashMap<String, User>();

    public boolean registerUser(User newUser) {
        String newUserName = newUser.getName();
        if(!userStoreMap.containsKey(newUserName)) {
            userStoreMap.put(newUserName, newUser);
            return true;
        }
        return false;
    }

    public User login(String name, String password) {
        if(userStoreMap.containsKey(name) && userStoreMap.get(name).getPassword().equals(password)) {
            return userStoreMap.get(name);
        }
        return null;
    }

    public boolean isValidName(String name) {
        if(userStoreMap.containsKey(name)) {
            return false;
        }else {
            return true;
        }
    }

    public void editUser(User user) {
        userStoreMap.put(user.getName(), user);
    }

    public void generateFakeUSers() {
        userStoreMap.put("ala", new User("ala", "ala123", "ala@mail.pl", "555333787"));
        userStoreMap.put("ola", new User("ola", "ola123", "ola@mail.pl", "555333787"));
        userStoreMap.put("aga", new User("aga", "aga123", "aga@mail.pl", "555333787"));
        userStoreMap.put("olga", new User("olga", "olga123", "olga@mail.pl", "555333787"));
    }

    public void printUserStoreMap() {
        for(Map.Entry<String, User> user: userStoreMap.entrySet()) {
            System.out.println("==========>>> " + user.getKey() + " <<<===========");
            System.out.println("User name: " + user.getKey());
            System.out.println("User password: " + user.getValue().getPassword());
            System.out.println("User email: " + user.getValue().getEmail());
            System.out.println("User phone number: " + user.getValue().getTelNumber());
        }
    }
}
