package com.example.customerror.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class HandleException {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<StudentError> handleStudentNotFoundException(StudentNotFoundException e){
        StudentError studentError = new StudentError(e.getMessage(), HttpStatus.NOT_FOUND, new Date());
        return new ResponseEntity<>(studentError, HttpStatus.NOT_FOUND);
    }
}
