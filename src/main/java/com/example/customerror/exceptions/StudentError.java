package com.example.customerror.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentError {
    private String message;
    private HttpStatus httpStatus;
    private Date date;
}
