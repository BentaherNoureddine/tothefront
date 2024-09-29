package com.noureddine.report_service.dto;

import com.noureddine.commonlibrary.model.Category;
import com.noureddine.commonlibrary.model.Forest;
import com.noureddine.commonlibrary.model.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReportDTO {

    Long id;

    UserDTO user;

    Category category;

    String description;

    ForestDTO forest;

    String location;


    Status status;

    String imagePath;

    Date date;


}



