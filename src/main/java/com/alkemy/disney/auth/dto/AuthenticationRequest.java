package com.alkemy.disney.auth.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class AuthenticationRequest {

    private String username;
    private String password;
}
