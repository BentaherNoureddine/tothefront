package com.noureddine.user_managemenet_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ReporterNotFoundException extends ResponseStatusException {

  public ReporterNotFoundException(){
      super(HttpStatus.NOT_FOUND,"no reporter found");
  }


}
