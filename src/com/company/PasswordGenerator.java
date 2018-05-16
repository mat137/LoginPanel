package com.company;

import java.util.Random;

public class PasswordGenerator {

    public String generatePassword(int theLength){
        Random r = new Random();
        String randomPassword = "";
        for (int i = 0; i < theLength; i++) {
            int rand = r.nextInt(3);
            int tmp;
            switch(rand) {
                case 0: // 1-9
                    tmp = r.nextInt(9) + 49;
                    randomPassword = randomPassword + (char) tmp;
                    break;
                case 1: // a-z
                    tmp = r.nextInt(26) + 97;
                    randomPassword = randomPassword + (char) tmp;
                    break;
                case 2: // A-Z
                    tmp = r.nextInt(26) + 65;
                    randomPassword = randomPassword + (char) tmp;
                    break;
            }
        }
        return randomPassword;
    }

}
