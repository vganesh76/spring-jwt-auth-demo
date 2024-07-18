package com.roomy.shop.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginUserDto implements Serializable {
    private String email;
    private String password;
}
