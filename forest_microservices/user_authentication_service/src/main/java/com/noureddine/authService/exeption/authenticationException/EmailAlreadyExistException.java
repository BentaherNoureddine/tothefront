package com.noureddine.authService.exeption.authenticationException;


import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EmailAlreadyExistException extends ResponseStatusException {

    public EmailAlreadyExistException(HttpStatus status, String message) {
        super(status, message);
    }




}


