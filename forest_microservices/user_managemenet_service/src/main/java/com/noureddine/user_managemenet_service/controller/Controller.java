package com.noureddine.user_managemenet_service.controller;



import com.noureddine.user_managemenet_service.repository.ReporterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("management")
@RequiredArgsConstructor
public class Controller {

    private final ReporterRepository reporterRepository;









}
