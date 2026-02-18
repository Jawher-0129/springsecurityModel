package com.example.springsecuritywahdi.controllers;

import com.example.springsecuritywahdi.dto.SignupRequest;
import com.example.springsecuritywahdi.entities.User;
import com.example.springsecuritywahdi.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")
public class SignupController {
    @Autowired
    private AuthService authService;

    @PostMapping("/p1")
    public ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest)
    {
        boolean isuserCreated=authService.createUser(signupRequest);

        if (isuserCreated)
        {
            return ResponseEntity.status(HttpStatus.CREATED).body("user created");
        }
        else
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error");
        }
    }


}
