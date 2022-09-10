package com.alkemy.disney.exception;

public class UserRegisterError extends RuntimeException{
    public UserRegisterError(String error){super(error);}
}
