package com.mycompany.chatapp;

public class Login implements IUserValidation {

    // Declaring variables
    String username;
    String password;
    String phoneNumber;
    String firstName;
    String lastName;

    // Constructor
    public Login(String username, String password, String phoneNumber,
                 String firstName, String lastName) {

        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Checks if the username has an underscore
    // and is no more than five characters
    @Override
    public boolean checkuserName() {

        return username.contains("_") && username.length() <= 5;
    }

    // Checks if the password meets the requirements
    @Override
    public boolean checkpasswordcomplexity() {

        if (password.length() < 8) {
            return false;
        }

        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecialCharacter = false;

        // Check each character in the password
        for (int i = 0; i < password.length(); i++) {

            char character = password.charAt(i);

            if (Character.isUpperCase(character)) {
                hasCapital = true;
            }

            if (Character.isDigit(character)) {
                hasNumber = true;
            }

            if (!Character.isLetterOrDigit(character)) {
                hasSpecialCharacter = true;
            }
        }

        return hasCapital && hasNumber && hasSpecialCharacter;
    }

    // Checks if the phone number uses the South African international code +27
    @Override
    public boolean checkphoneNumber() {

        return phoneNumber.matches("^\\+27[0-9]{9}$");
    }

    // Registers the user and returns the required message
    public String registerUser() {

        if (!checkuserName()) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        if (!checkpasswordcomplexity()) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkphoneNumber()) {
            return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        }

        return "Username successfully captured."
                + "Password successfully captured."
                + "Cell number successfully captured.";
    }

    // Checks if the login details are correct
    public boolean loginUser(String enteredUsername, String enteredPassword) {

        return username.equals(enteredUsername)
                && password.equals(enteredPassword);
    }

    // Returns the login status message
    public String returnLoginStatus(String enteredUsername, String enteredPassword) {

        if (loginUser(enteredUsername, enteredPassword)) {

            return "Welcome " + firstName + " " + lastName
                    + " it is great to see you.";
        }

        return "Username or password incorrect, please try again.";
    }
}