package com.example.customerror.dao;

import com.example.customerror.domain.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentDao extends CrudRepository<Student, Long> {
}
