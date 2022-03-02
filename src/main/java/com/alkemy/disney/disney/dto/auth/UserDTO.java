package com.alkemy.disney.disney.dto.auth;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
public class UserDTO {
    @Email(regexp = ".+@.+\\..+")
    private String username;
    @Size(min = 8)
    private String password;
}
