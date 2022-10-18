package com.elcom.controller;
import com.elcom.auth.CustomUserDetails;
import com.elcom.auth.LoginRequest;
import com.elcom.auth.LoginResponse;
import com.elcom.auth.jwt.JwtTokenProvider;
import com.elcom.model.*;
import com.elcom.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api")
public class UserManagementController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserManagementController.class.getName());

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;
    @Autowired
    private UserRepository userRepository;


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public LoginResponse authenticateUser(@Valid @RequestBody LoginRequest loginRequest) throws ValidationException {
        // Xác thực từ username và password.
        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername()
                            ,loginRequest.getPassword()
                    )
            );
        }catch(AuthenticationException ex) {
            LOGGER.error(ex.toString());
            throw new ValidationException("Sai username/password.");
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // Trả về jwt cho người dùng.
        String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
        return new LoginResponse(jwt);
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        loginRequest.getUsername(),
//                        loginRequest.getPassword()
//                )
//        );
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
//        return new LoginResponse(jwt);
    }
    @GetMapping("/users")
    public List<User> getAllUser(){
        List<User> allUser = (List<User>) userRepository.findAll();
        return allUser;
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user)
    {
        userRepository.save(user);
        return new ResponseEntity<User>(HttpStatus.OK);
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> removeUser(@PathVariable("id") Long id)
    {
        userRepository.deleteById(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

    }
