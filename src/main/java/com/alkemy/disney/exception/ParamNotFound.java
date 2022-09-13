package com.alkemy.disney.exception;

import org.springframework.http.HttpStatus;

public class ParamNotFound extends RuntimeException {
    public ParamNotFound(String error){ super(error);}
}
