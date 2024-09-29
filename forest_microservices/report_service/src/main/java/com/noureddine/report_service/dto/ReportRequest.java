package com.noureddine.report_service.dto;




import com.noureddine.commonlibrary.model.Forest;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ReportRequest (



    @NotNull(message = "the category mandatory")
    String category,


    @NotNull(message = "the description mandatory")
    String description,



    @NotNull(message = "the description mandatory")
    Forest forest,


    @NotNull(message = "the localisation mandatory")
    String  location,

    @NotNull(message = "the reporter mandatory")
    UUID reporter


    ) {

}

