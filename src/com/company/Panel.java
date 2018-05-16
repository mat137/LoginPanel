package com.company;

import java.util.Scanner;

public class Panel {

    private UserStore userStore;
    private Validator validate = new Validator();
    private PasswordGenerator passwordGenerator = new PasswordGenerator();

    Scanner in = new Scanner(System.in);

    public Panel(UserStore userStore) {
        this.userStore = userStore;
    }

    public void start() {
//        userStore.generateFakeUSers(); // creating fake accounts for testing
        mainMenu();
    }

    private void mainMenu() {
        System.out.println("==========>>> Main Menu <<<==========");
        System.out.println("Choose option: ");
        System.out.println("1 - Login");
        System.out.println("2 - Register");
        System.out.println("3 - Show all users");

        int choice = in.nextInt();
        in.nextLine();

        switch(choice) {
            case 1:
                loginUser();

            case 2:
                registerNewUser();

            case 3:
                userStore.printUserStoreMap();
                mainMenu();
        }
    }

    private void loginUser() {
        String loginName;
        String loginPassword;

        System.out.println("==========>>> Login <<<==========");
        System.out.print("Name:  ");
        loginName = in.nextLine();

        System.out.print("Password:  ");
        loginPassword = in.nextLine();

        User loggedUser = userStore.login(loginName, loginPassword);
        if(loggedUser != null) {
            System.out.println("Logged in!");
            userMenu(loggedUser);
        } else {
            System.out.println("Invalid combination of password and name.");
            loginUser();
        }
    }

    private void userMenu(User user) {
        System.out.println("==========>>> User Menu <<<==========");
        System.out.println("Choose option: ");
        System.out.println("1 - Print your data");
        System.out.println("2 - change your email");
        System.out.println("3 - change your phone number");
        System.out.println("0 - Log out");

        int choice = in.nextInt();
        in.nextLine();

        switch(choice) {
            case 1:
                printUser(user);
                userMenu(user);
                break;
            case 2:
                changeEmail(user);
                System.out.println("Changing email done.");
                userMenu(user);
                break;
            case 3:
                changePhone(user);
                System.out.println("Changing phone number done.");
                userMenu(user);
                break;
            case 0:
                mainMenu();
                break;
        }
    }

    private void changeEmail(User user) {
        isValidMail(user);
        userStore.editUser(user);
    }
    private void changePhone(User user) {
        isValidPhone(user);
        userStore.editUser(user);
    }

    private void registerNewUser() {
        User newUser = new User();

        System.out.println("==========>>> Register <<<==========");

        // name
        System.out.print("Name:  ");
        String userName = in.nextLine();
        while(!userStore.isValidName(userName) || !validate.validateName(userName)) {
            System.out.println("Name too short or name is already taken. Try again: ");
            userName = in.nextLine();
        }
        newUser.setName(userName);

        // password input & validate
        isValidPassword(newUser);

        // email input & validate
        isValidMail(newUser);

        // phone input & validate
        isValidPhone(newUser);

        // Sending new user to database
        if(userStore.registerUser(newUser)){
            System.out.println("Registration successful.");
            onSuccess(newUser);
        } else {
            System.out.println("User with such name already exist.");
        }
    }

    private void isValidPassword(User user) {
        System.out.print("Password(optional): ");
        String userPassword = in.nextLine();

        if(userPassword.length() == 0){
            userPassword = passwordGenerator.generatePassword(8);
            user.setPassword(userPassword);
        } else {
            int[] errorsTab = validate.validatePassword(userPassword);
            String errorMessage = "";
            for (int i = 0; i < errorsTab.length; i++) {
                int val = errorsTab[i];
                switch (i) {
                    case 0:
                        if(val ==1) {
                            errorMessage += "Too short. ";
                            continue;
                        }
                    case 1:
                        if(val ==1) {
                            errorMessage += "Missing capital char. ";
                            continue;
                        }
                    case 2:
                        if(val ==1) {
                            errorMessage += "Missing alphanumeric char. ";
                            continue;
                        }
                    case 3:
                        if(val ==1) {
                            errorMessage += "Missing special char. ";
                            continue;
                        }
                }
            }
            if(errorMessage.equals("")) {
                user.setPassword(userPassword);
            } else {
                System.out.println(errorMessage);
                isValidPassword(user);
            }
        }
    }

    private void isValidMail(User user) {
        System.out.print("E-mail address:  ");
        String userEmail = in.nextLine();
        while(!validate.validateMail(userEmail)){
            System.out.print("Invalid email. Try again:  ");
            userEmail = in.nextLine();
        }
        user.setEmail(userEmail);
    }

    private void isValidPhone(User user) {
        System.out.print("Telephone number:  ");
        String userPhoneNumber = in.nextLine();
        while(!validate.validatePhoneNumber(userPhoneNumber)){
            System.out.println("Invalid phone number. Try again: ");
            userPhoneNumber = in.nextLine();
        }
        user.setTelNumber(userPhoneNumber);
    }

    private void onSuccess(User user) {
        System.out.println("Logged as --> " + user.getName());
        userMenu(user);
    }

    private void printUser(User user) {
        System.out.println("Name: " + user.getName()
            + "\nPassword: " + user.getPassword() + "\nEmail: " + user.getEmail() + "\nTel. : " + user.getTelNumber());
    }

}
