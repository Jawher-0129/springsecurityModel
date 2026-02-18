package com.example.springsecuritywahdi.services;

import com.example.springsecuritywahdi.dto.SignupRequest;
import com.example.springsecuritywahdi.entities.Role;
import com.example.springsecuritywahdi.entities.User;
import com.example.springsecuritywahdi.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean createUser(SignupRequest signupRequest) {
        if (userRepository.existsByEmail(signupRequest.getEmail()))
        {
            return false;
        }
        User user=new User();
        BeanUtils.copyProperties(signupRequest,user);
        String hash=passwordEncoder.encode(signupRequest.getPassword());
        user.setPassword(hash);
        user.setRole(Role.CLIENT);
        userRepository.save(user);
        return true;
    }
}
