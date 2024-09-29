package com.noureddine.user_managemenet_service.dto;

import com.noureddine.commonlibrary.model.Report;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReporterDTO {
    private UUID id;
    private String username;
    private String email;
    private boolean active;
    private String password;
    private List<Report> reports;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedDate;
}