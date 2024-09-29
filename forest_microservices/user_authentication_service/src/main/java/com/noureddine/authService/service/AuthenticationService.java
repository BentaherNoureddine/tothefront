package com.noureddine.authService.service;



import com.noureddine.authService.dto.AuthenticationRequest;
import com.noureddine.authService.dto.AuthenticationResponse;
import com.noureddine.authService.dto.RegistrationRequest;
import com.noureddine.authService.repository.ReporterRepository;
import com.noureddine.authService.security.JwtService;
import com.noureddine.commonlibrary.model.Profile;
import com.noureddine.commonlibrary.model.Reporter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.HashMap;


@Service
@RequiredArgsConstructor
public class AuthenticationService {



    private final ReporterRepository reporterRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;





    //register method that will be called at the authentication controller
    public void registerReporter(RegistrationRequest request) {


        Profile profile = new Profile();
        profile.setFullName(request.getFullName());

        //building a new reporter
            Reporter reporter = new Reporter();
            reporter.setEmail(request.getEmail());
            reporter.setPassword(passwordEncoder.encode(request.getPassword()));
            reporter.setActive(true);
            reporter.setCreatedAt(LocalDateTime.now());
            reporter.setProfile(profile);

            //saving user
            reporterRepository.save((Reporter) reporter);

            for(int i =0;i<10;i++){
                System.out.println();            }


    }


    //authentication method that will be called at the authentication controller
    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        var auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var claims = new HashMap<String, Object>();
        var reporter = ((Reporter) auth.getPrincipal());
        claims.put("userId", reporter.getId());
        var jwtToken = jwtService.generateToken(claims, reporter);

        //return a login token
        return AuthenticationResponse.builder().token(jwtToken).build();
    }


}
