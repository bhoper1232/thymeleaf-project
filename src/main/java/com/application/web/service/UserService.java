package com.application.web.service;

import com.application.web.dto.RegistrationDto;
import com.application.web.models.UserEntity;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);

    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);
}
