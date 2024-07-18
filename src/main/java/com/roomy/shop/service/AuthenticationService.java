package com.roomy.shop.service;

import com.roomy.shop.domain.entity.User;
import com.roomy.shop.dto.LoginUserDto;
import com.roomy.shop.dto.RegisterUserDto;

public interface AuthenticationService {
    User signup(RegisterUserDto input);
    User authenticate(LoginUserDto input);
}
