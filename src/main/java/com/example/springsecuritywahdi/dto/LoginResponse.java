package com.example.springsecuritywahdi.dto;

import com.example.springsecuritywahdi.entities.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponse {
    private String jwtToken;
    private long id;
    private String nom;
    private String prenom;
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;

}
