package com.example.SpringProject.registration;

import com.example.SpringProject.user.Role;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

import java.util.Collection;
import java.util.List;

@Data
public class RegistrationRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean isEnabled= false;

    private List<Role> roles;
}

