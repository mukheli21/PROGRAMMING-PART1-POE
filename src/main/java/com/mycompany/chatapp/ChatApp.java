package com.mycompany.chatapp;

import java.util.Scanner;

public class ChatApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("           CHAT APP");
        System.out.println("=================================");

        // Get the user's details
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();
        
        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        System.out.print("Enter your South African cell phone number: ");
        String cellPhoneNumber = scanner.nextLine();

        // Create the Login object
        Login login = new Login(
                username,
                password,
                cellPhoneNumber,
                firstName,
                lastName
        );

        // Display registration result
        System.out.println();
        System.out.println("Registration Status:");
        System.out.println(login.registerUser());

        // Check if all registration details are correct
        if (login.checkUserName()
                && login.checkPasswordComplexity()
                && login.checkCellPhoneNumber()) {

            System.out.println();
            System.out.println("=================================");
            System.out.println("              LOGIN");
            System.out.println("=================================");

            System.out.print("Enter your username: ");
            String enteredUsername = scanner.nextLine();

            System.out.print("Enter your password: ");
            String enteredPassword = scanner.nextLine();

            // Check login details
            boolean loginSuccessful = login.loginUser(
                    enteredUsername,
                    enteredPassword
            );

            System.out.println();
            System.out.println(login.returnLoginStatus(
                    enteredUsername,
                    enteredPassword
            ));

        } else {

            System.out.println();
            System.out.println(
                    "Please correct your registration details and try again."
            );   
        }

        scanner.close();
    }
}