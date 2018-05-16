package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        UserStore userStore = new UserStore();
        Panel panel = new Panel(userStore);

        panel.start();
    }
}
