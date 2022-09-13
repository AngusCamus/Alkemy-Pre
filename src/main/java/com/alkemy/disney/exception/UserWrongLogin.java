package com.alkemy.disney.exception;

public class UserWrongLogin extends RuntimeException{
    public UserWrongLogin(String error) { super(error);}
}
