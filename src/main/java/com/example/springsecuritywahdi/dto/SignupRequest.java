package com.example.springsecuritywahdi.dto;

import com.example.springsecuritywahdi.entities.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequest {
    public String email;
    public String password;
    private String nom;
    private String prenom;
    @Enumerated(EnumType.STRING)
    private Role role;
}
