package com.example.springsecuritywahdi.services;

import com.example.springsecuritywahdi.dto.SignupRequest;

public interface IAuthService {
    boolean createUser(SignupRequest signupRequest);
}
