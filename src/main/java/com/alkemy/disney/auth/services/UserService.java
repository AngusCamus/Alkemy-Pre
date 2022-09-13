package com.alkemy.disney.auth.services;

import com.alkemy.disney.auth.dto.AuthenticationRequest;
import com.alkemy.disney.auth.dto.UserDTO;
import com.alkemy.disney.auth.entities.UserEntity;
import com.alkemy.disney.auth.repositories.UserRepository;
import com.alkemy.disney.exception.EnumErrors;
import com.alkemy.disney.exception.UserRegisterError;
import com.alkemy.disney.exception.UserWrongLogin;
import com.alkemy.disney.services.impl.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private EmailServiceImpl emailService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;



    public boolean save(UserDTO userDTO){
        this.userExist(userDTO);
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDTO.getUsername());
        String password = passwordEncoder.encode(userDTO.getPassword());
        userEntity.setPassword(password);
        userEntity = userRepository.save(userEntity);

        if(userEntity != null){
            emailService.sendWelcomeEmail(userEntity.getUsername());
        };

        return userEntity != null;
    }
    public boolean userExist(UserDTO userDTO){
        if(userRepository.findByUsername(userDTO.getUsername()) !=null){
            throw new UserRegisterError(EnumErrors.USER_ALREADY_EXIST.getErrorMessage());
        }
        return false;
    }
    public String userAuth(AuthenticationRequest authRequest){
        UserDetails userDetails;
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(auth);
            userDetails = (UserDetails) auth.getPrincipal();
        } catch (BadCredentialsException e) {
            throw new UserWrongLogin(EnumErrors.WRONG_CREDENTIALS.getErrorMessage());
        }
        final String jwt = jwtUtils.generateToken(userDetails);
        return jwt;
    }

}
