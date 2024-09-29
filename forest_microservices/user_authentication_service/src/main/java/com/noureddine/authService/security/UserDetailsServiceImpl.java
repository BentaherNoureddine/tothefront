package com.noureddine.authService.security;




import com.noureddine.authService.repository.ReporterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;





@Service
@RequiredArgsConstructor

public class
UserDetailsServiceImpl implements UserDetailsService {

    private final ReporterRepository reporterRepository;


    //LOAD USER BY USER NAME
    @Override
    //the @Transactional means when we load the user will be loaded with the roles authorities
    @Transactional
    public UserDetails loadUserByUsername(String email  ) throws UsernameNotFoundException {
        return reporterRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

    }






}
