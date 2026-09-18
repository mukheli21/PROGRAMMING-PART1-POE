package com.mycompany.chatapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    // Test if the username is correctly formatted
    @Test
    public void testCheckUserNameCorrect() {
        Login user = new Login(
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976",
                "Thakhie",
                "Mukheli"
        );

        assertTrue(user.checkUserName());
    }

    // Test if the username is incorrectly formatted
    @Test
    public void testCheckUserNameIncorrect() {
        Login user = new Login(
                "kyle!!!!!!",
                "Ch&&sec@ke99!",
                "+27838968976",
                "Thakhie",
                "Mukheli"
        );

        assertFalse(user.checkUserName());
    }

    // Test if the password meets the complexity requirements
    @Test
    public void testPasswordCorrect() {
        Login user = new Login(
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976",
                "Thakhie",
                "Mukheli"
        );

        assertTrue(user.checkPasswordComplexity());
    }

    // Test if the password does not meet the complexity requirements
    @Test
    public void testPasswordIncorrect() {
        Login user = new Login(
                "kyl_1",
                "password",
                "+27838968976",
                "Thakhie",
                "Mukheli"
        );

        assertFalse(user.checkPasswordComplexity());
    }

    // Test if the phone number is correctly formatted
    @Test
    public void testPhoneNumberCorrect() {
        Login user = new Login(
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976",
                "Thakhie",
                "Mukheli"
        );

        assertTrue(user.checkCellPhoneNumber());
    }

    // Test if the phone number is incorrectly formatted
    @Test
    public void testPhoneNumberIncorrect() {
        Login user = new Login(
                "kyl_1",
                "Ch&&sec@ke99!",
                "08966553",
                "Thakhie",
                "Mukheli"
        );

        assertFalse(user.checkCellPhoneNumber());
    }

    // Test if login is successful
    @Test
    public void testLoginSuccessful() {
        Login user = new Login(
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976",
                "Thakhie",
                "Mukheli"
        );

        assertTrue(user.loginUser(
                "kyl_1",
                "Ch&&sec@ke99!"
        ));
    }

    // Test if login fails
    @Test
    public void testLoginFailed() {
        Login user = new Login(
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976",
                "Thakhie",
                "Mukheli"
        );

        assertFalse(user.loginUser(
                "Wrong_1",
                "wrongpassword"
        ));
    }

    // Test the message returned when all registration details are valid
    @Test
    public void testRegisterUserSuccess() {
        Login user = new Login(
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976",
                "Thakhie",
                "Mukheli"
        );

        assertEquals(
                "Username successfully captured. "
                        + "Password successfully captured. "
                        + "Cell number successfully captured.",
                user.registerUser()
        );
    }

    // Test the message returned when the username is invalid
    @Test
    public void testRegisterUserUsernameIncorrect() {
        Login user = new Login(
                "kyle!!!!!!",
                "Ch&&sec@ke99!",
                "+27838968976",
                "Thakhie",
                "Mukheli"
        );

        assertEquals(
                "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.",
                user.registerUser()
        );
    }

    // Test the message returned when the password is invalid
    @Test
    public void testRegisterUserPasswordIncorrect() {
        Login user = new Login(
                "kyl_1",
                "password",
                "+27838968976",
                "Thakhie",
                "Mukheli"
        );

        assertEquals(
                "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.",
                user.registerUser()
        );
    }

    // Test the message returned when the phone number is invalid
    @Test
    public void testRegisterUserCellNumberIncorrect() {
        Login user = new Login(
                "kyl_1",
                "Ch&&sec@ke99!",
                "08966553",
                "Thakhie",
                "Mukheli"
        );

        assertEquals(
                "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.",
                user.registerUser()
        );
    }

    // Test the welcome message returned on a successful login
    @Test
    public void testReturnLoginStatusSuccessful() {
        Login user = new Login(
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976",
                "Thakhie",
                "Mukheli"
        );

        assertEquals(
                "Welcome Thakhie Mukheli it is great to see you.",
                user.returnLoginStatus("kyl_1", "Ch&&sec@ke99!")
        );
    }

    // Test the failure message returned on an unsuccessful login
    @Test
    public void testReturnLoginStatusFailed() {
        Login user = new Login(
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838968976",
                "Thakhie",
                "Mukheli"
        );

        assertEquals(
                "Username or password incorrect, please try again.",
                user.returnLoginStatus("Wrong_1", "wrongpassword")
        );
    }
}