package com.roomy.shop.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class RegisterUserDto implements Serializable {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
