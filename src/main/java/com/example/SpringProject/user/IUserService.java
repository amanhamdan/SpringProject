package com.example.SpringProject.user;

import com.example.SpringProject.registration.RegistrationRequest;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getAllUsers();
    User registerUser(RegistrationRequest registrationRequest );
    User findByEmail(String email);

}
