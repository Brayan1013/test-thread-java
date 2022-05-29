package com.example.customerror.controller;

import com.example.customerror.dao.StudentDao;
import com.example.customerror.domain.Student;
import com.example.customerror.exceptions.StudentNotFoundException;
import com.example.customerror.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getEmployee(@PathVariable Long id){
        Student studentById = studentService.findStudentById(id);
        return new ResponseEntity<>(studentById, HttpStatus.FOUND);
    }
}
