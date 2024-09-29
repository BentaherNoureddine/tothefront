package com.noureddine.user_managemenet_service.service;




import com.noureddine.commonlibrary.model.Reporter;
import com.noureddine.user_managemenet_service.dto.ReporterDTO;
import com.noureddine.user_managemenet_service.dto.UpdateUserRequest;
import com.noureddine.user_managemenet_service.repository.ReporterRepository;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;




@Service
@RequiredArgsConstructor
public class ReporterService {

    private final ReporterRepository reporterRepository;

    private final PasswordEncoder passwordEncoder;





    //FIND REPORTER BY EMAIL
    public ReporterDTO  findReporterByEmail(String email){

        Reporter reporter;
        try {
            reporter = reporterRepository.findByEmail(email);
            if(reporter == null){
                throw new NotFoundException("reporter not found");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return ReporterDTO.builder()
                .id(reporter.getId())
                .username(reporter.getProfile().getFullName())
                .email(reporter.getEmail())
                .active(reporter.isActive())
                .password(reporter.getPassword())
                .reports(reporter.getReports())
                .createdAt(reporter.getCreatedAt())
                .lastModifiedDate(reporter.getLastModifiedDate())
                .build();
    }



    //UPDATE REPORTER
    @Transactional
    public ResponseEntity<String> updateUser(UUID id, UpdateUserRequest request) {
        Optional<Reporter> reporterOptional = reporterRepository.findById(id);

        if (reporterOptional.isPresent()) {
            Reporter reporter = reporterOptional.get();

            // Update full name if present in the request
            if (request.getProfile() != null) {
                reporter.setProfile(request.getProfile());
            }

            // Update password if present in the request
            if (request.getPassword() != null) {
                String hashedPassword = passwordEncoder.encode(request.getPassword());
                reporter.setPassword(hashedPassword);
            }

            // Save the updated reporter back to the repository
            reporterRepository.save(reporter);

            return ResponseEntity.ok("USER SUCCESSFULLY UPDATED");
        } else {
            throw new NotFoundException("reporter not found");
        }
    }



    //DELETE USER
    public ResponseEntity<?> deleteUser(UUID id) {
        Optional<Reporter> reporterOptional = reporterRepository.findById(id);
        if (reporterOptional.isPresent()) {
            reporterRepository.delete(reporterOptional.get());
            return ResponseEntity.ok("USER SUCCESSFULLY DELETED");
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "REPORTER NOT FOUND");
        }
    }

}
