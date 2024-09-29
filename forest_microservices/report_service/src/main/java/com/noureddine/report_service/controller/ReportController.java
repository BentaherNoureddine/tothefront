package com.noureddine.report_service.controller;



import com.noureddine.commonlibrary.model.Category;
import com.noureddine.commonlibrary.model.Forest;
import com.noureddine.commonlibrary.model.Report;
import com.noureddine.commonlibrary.model.User;
import com.noureddine.report_service.repository.ReportRepository;
import com.noureddine.report_service.dto.ReportRequest;
import com.noureddine.report_service.service.ReportService;
import jakarta.validation.Valid;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.UUID;


@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200" ,"http://192.168.1.16:4200"})
public class ReportController {

    private final ReportService reportService;

    private final ReportRepository reportRepository;



    //CREATE A REPORT
    @PostMapping("/create")
    public ResponseEntity<?> createReport(
            @RequestParam(value = "image", required = false) MultipartFile image,
            @RequestParam("category") String category,
            @RequestParam("forest") Forest forest,
            @RequestParam("reporter") UUID reporter,
            @RequestParam("description") String description,
            @RequestParam("location") String location)
           {
        try {
            String imagePath = null;
            if (image != null && !image.isEmpty()) {
                // SAVE THE IMAGE AND GET THE IT'S PATH
                imagePath = reportService.saveImageToStorage("src/main/resources/static/images", image);
            }

            ReportRequest request = new ReportRequest(category,description,forest,location,reporter);


            reportService.create(request, imagePath);

            return ResponseEntity.status(HttpStatus.CREATED).body("Report created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    //FETCH ALL REPORTS
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllReports() {
        try {
            return ResponseEntity.ok(reportService.getAllReports());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }






    //FETCH REPORTS BY ID
    @GetMapping("/getReport/{id}")
    public Report getReport(@PathVariable Long id) {

        return  reportRepository.findById(id).orElseThrow(() -> new NotFoundException("Report not found"));

    }

    //FETCH AN IMAGE BY THE GIVEN PATH
    @GetMapping("/getImage/{imagePath}")
    public ResponseEntity<byte[]> getImage(@PathVariable String imagePath) {
        try {
            byte[] imageBytes = reportService.getImage("src/main/resources/static/images", imagePath);
            if (imageBytes != null) {
                MediaType mediaType = MediaType.IMAGE_JPEG; // or determine the type dynamically
                return ResponseEntity.ok()
                        .contentType(mediaType)
                        .body(imageBytes);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}






