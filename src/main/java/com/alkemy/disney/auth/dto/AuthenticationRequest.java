package com.alkemy.disney.auth.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;

@Data
public class AuthenticationRequest {

    @Email
    private String username;
    private String password;
}
