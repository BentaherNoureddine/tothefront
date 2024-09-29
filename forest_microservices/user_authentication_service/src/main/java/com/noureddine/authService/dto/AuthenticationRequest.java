package com.noureddine.authService.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AuthenticationRequest {


    @NotEmpty(message = "email is mandatory")
    @NotBlank(message = "password is mandatory")
    private String email;

    @NotEmpty(message = "Password is mandatory")
    @NotBlank(message = "Password is mandatory")
    @Size(min = 8,message = "Password should have at least 8 characters ")
    private String password;
}
