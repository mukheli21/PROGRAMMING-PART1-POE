package com.mycompany.chatapp;

// Interface that lists the validation methods a user class must have
public interface IUserValidation {

    boolean checkuserName();
    boolean checkpasswordcomplexity();
    boolean checkphoneNumber();
}

