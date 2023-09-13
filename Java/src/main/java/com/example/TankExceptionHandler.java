package com.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.io.IOException;

@ControllerAdvice
public class TankExceptionHandler {

    public ResponseEntity<String> handleIOException (Exception exc) {
        return new ResponseEntity<>("Buffer failed", HttpStatus.I_AM_A_TEAPOT);
    }
}
