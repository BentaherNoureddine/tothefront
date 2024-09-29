package com.noureddine.authService.controller;


import com.noureddine.authService.dto.AuthenticationRequest;
import com.noureddine.authService.dto.AuthenticationResponse;
import com.noureddine.authService.repository.ReporterRepository;
import com.noureddine.authService.service.AuthenticationService;
import com.noureddine.authService.dto.RegistrationRequest;
import com.noureddine.authService.exeption.authenticationException.EmailAlreadyExistException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("auth")
@CrossOrigin(origins = {"http://localhost:9654" ,"http://192.168.0.17"})
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final ReporterRepository reporterRepository;


    //REPORTER REGISTRATION
    @PostMapping("/register")
    public ResponseEntity<String> registerReporter(@RequestBody @Valid final RegistrationRequest request) {
        try {
            // Check if user already exists
            if (reporterRepository.findByEmail(request.getEmail()).isPresent()) {
                throw new EmailAlreadyExistException(HttpStatus.CONFLICT, "Email already exists");
            }

            // Register the new user
            authenticationService.registerReporter(request);
            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");

        } catch (EmailAlreadyExistException e) {
            // This exception should be handled in the service layer, if it's possible
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while registering the user");
        }
    }


    //AUTHENTICATION API
    @CrossOrigin(origins ="http://localhost:9654" )
    @GetMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ) {
        AuthenticationRequest authRequest = new AuthenticationRequest(email,password);
        return ResponseEntity.ok(authenticationService.authenticate(authRequest));
    }



}
