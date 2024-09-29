package com.noureddine.report_service.service;



import com.noureddine.commonlibrary.model.Category;
import com.noureddine.commonlibrary.model.Report;
import com.noureddine.commonlibrary.model.Status;
import com.noureddine.report_service.dto.ForestDTO;
import com.noureddine.report_service.dto.ReportDTO;
import com.noureddine.report_service.dto.UserDTO;
import com.noureddine.report_service.repository.ReportRepository;
import com.noureddine.report_service.dto.ReportRequest;
import com.noureddine.report_service.repository.ReporterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ReportService {
    private final ReportRepository reportRepository;

    private final ReporterRepository reporterRepository;





    //CREATE REPORT
    public  void create(ReportRequest request,String imagePath) throws Exception {

        Report report = Report.builder()
                .category(Category.valueOf(request.category().toUpperCase()))
                .imagePath(imagePath)
                .reporter(reporterRepository.findReporterById(request.reporter()))
                .status(Status.STATUS1)
                .forest(request.forest())
                .location(request.location())
                .description(request.description())
                .createdAt(Timestamp.valueOf(LocalDateTime.now()))
                .build();
        for(int i = 0 ;i<5 ;i++){
            System.out.println(request.forest());
        }

        reportRepository.save(report);


    }


    //FETCH ALL  REPORTS
    public List<ReportDTO> getAllReports() throws Exception {
        List<Report> reports = reportRepository.findAll();

        // Map each Report to ReportDTO
        return reports.stream()
                .map(this::mapToReportDTO)
                .collect(Collectors.toList());
    }

    private ReportDTO mapToReportDTO(Report report) {

        try {
            ForestDTO forestDTO = new ForestDTO(report.getForest().getId(), report.getForest().getName());
            UserDTO userDTO = new UserDTO(report.getReporter().getProfile());
            return new ReportDTO(
                    report.getId(),
                    userDTO,
                    report.getCategory(),
                    report.getDescription(),
                    forestDTO,
                    report.getLocation(),
                    report.getStatus(),
                    report.getImagePath(),
                    report.getCreatedAt()
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    //GETTING THE REPORT BY ID
    public  Report getReportById(Long reportId) throws Exception {

        return reportRepository.findById(reportId).orElseThrow();
    }


    ///////////////IMAGE SECTION /////////



    // SAVE AN IMAGE TO A LOCAL DIRECTORY
    public String saveImageToStorage(String uploadDirectory, MultipartFile imageFile) throws IOException {
        String uniqueFileName = UUID.randomUUID().toString() + "_" + imageFile.getOriginalFilename();
        Path uploadPath = Path.of(uploadDirectory);
        Path filePath = uploadPath.resolve(uniqueFileName);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return uniqueFileName;
    }


    // GET IMAGE BY IT S NAME
    public byte[] getImage(String imageDirectory, String imageName) throws IOException {
        Path imagePath = Path.of(imageDirectory, imageName);

        if (Files.exists(imagePath)) {
            return Files.readAllBytes(imagePath);
        } else {
            return null;
        }
    }


}
