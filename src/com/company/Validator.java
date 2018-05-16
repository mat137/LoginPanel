package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public boolean validateMail(String mail) {
        if(mail.matches("\\w+@\\w+\\.(pl|com)")) {
            return true;
        }
        return false;
    }

    public boolean validateName(String name) {

        return name.length() >= 3 ? true: false;
    }

    public int[] validatePassword(String password) {

        int[] result = new int[4];

        if(password.length() < 8) {
            result[0] = 1;
        }

        if(!password.matches(".*[A-Z].*")) {
            result[1] = 1;
        }

        if(!password.matches(".*[0-9].*")) {
            result[2] = 1;
        }

        if(!password.matches(".*[^A-Za-z0-9].*")) {
            result[3] = 1;
        }

        return result;
    }

    public boolean validatePhoneNumber(String phoneNumber) {
        try {
            int parsePhoneNumber = Integer.parseInt(phoneNumber);
//                System.out.println("Valid phone!");
            return true;
        }catch(NumberFormatException e) {
            return false;
        }
    }

}
