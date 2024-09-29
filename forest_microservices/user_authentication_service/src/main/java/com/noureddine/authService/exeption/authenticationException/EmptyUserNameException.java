package com.noureddine.authService.exeption.authenticationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EmptyUserNameException extends ResponseStatusException {

    public EmptyUserNameException() {
        super(HttpStatus.BAD_REQUEST, "No email or phone number provided");
    }

}
