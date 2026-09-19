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
                "+27838969876",
                "Thakhie",
                "Mukheli"
        );

        assertTrue(user.checkuserName());
    }

    // Test if the username is incorrectly formatted
    @Test
    public void testCheckUserNameIncorrect() {
        Login user = new Login(
                "kyle!!!!!!*",
                "Ch&&sec@ke99!",
                "+27838969876",
                "Thakhie",
                "Mukheli"
        );

        assertFalse(user.checkuserName());
    }

    // Test if the password meets the complexity requirements
    @Test
    public void testPasswordCorrect() {
        Login user = new Login(
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838969876",
                "Thakhie",
                "Mukheli"
        );

        assertTrue(user.checkpasswordcomplexity());
    }

    // Test if the password does not meet the complexity requirements
    @Test
    public void testPasswordIncorrect() {
        Login user = new Login(
                "kyl_1",
                "password",
                "+27838969876",
                "Thakhie",
                "Mukheli"
        );

        assertFalse(user.checkpasswordcomplexity());
    }

    // Test if the phone number is correctly formatted
    @Test
    public void testPhoneNumberCorrect() {
        Login user = new Login(
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838969876",
                "Thakhie",
                "Mukheli"
        );

        assertTrue(user.checkphoneNumber());
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

        assertFalse(user.checkphoneNumber());
    }

    // Test if login is successful
    @Test
    public void testLoginSuccessful() {
        Login user = new Login(
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838969876",
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
                "+27838969876",
                "Thakhie",
                "Mukheli"
        );

        assertFalse(user.loginUser(
                "Wrong_1",
                "wrongpassword"
        ));
    }

    // Test that Login correctly implements the IUserValidation interface
    @Test
    public void testLoginImplementsInterface() {
        Login user = new Login(
                "kyl_1",
                "Ch&&sec@ke99!",
                "+27838969876",
                "Thakhie",
                "Mukheli"
        );

        assertTrue(user instanceof IUserValidation);
    }
}

