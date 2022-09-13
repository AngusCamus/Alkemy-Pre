package com.alkemy.disney.auth.services;

import com.alkemy.disney.auth.dto.AuthenticationRequest;
import com.alkemy.disney.auth.dto.UserDTO;
import com.alkemy.disney.auth.entities.UserEntity;
import com.alkemy.disney.auth.repositories.UserRepository;
import com.alkemy.disney.exception.EnumErrors;
import com.alkemy.disney.exception.UserWrongLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsCustomService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username){
        UserEntity userEntity = userRepository.findByUsername(username);


        return new User(userEntity.getUsername(), userEntity.getPassword(), Collections.emptyList());
    }




}
