package com.example.springsecuritywahdi.controllers;

import com.example.springsecuritywahdi.dto.LoginRequest;
import com.example.springsecuritywahdi.dto.LoginResponse;
import com.example.springsecuritywahdi.entities.User;
import com.example.springsecuritywahdi.services.jwt.UserService;
import com.example.springsecuritywahdi.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
   @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/p1")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest)
    {
        try
        {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword())
            );
        }catch (AuthenticationException e)
        {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        UserDetails userDetails;
        User user=new User();

            userDetails=userService.loadUserByUsername(loginRequest.getEmail());
        String jwt = jwtUtil.generateToken(userDetails.getUsername());
        LoginResponse loginResponse = new LoginResponse(jwt,user.getId(),user.getNom(),user.getPrenom(),user.getEmail(),user.getRole());
        return ResponseEntity.ok(loginResponse);
    }








}
