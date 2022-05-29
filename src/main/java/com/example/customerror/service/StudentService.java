package com.example.customerror.service;

import com.example.customerror.dao.StudentDao;
import com.example.customerror.domain.Student;
import com.example.customerror.exceptions.StudentNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentDao studentDao;

    public Student findStudentById(Long id){
        return studentDao.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("THE STUDENT WAS NOT FOUND"));
    }
}
