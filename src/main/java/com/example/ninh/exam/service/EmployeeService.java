package com.example.ninh.exam.service;

import com.example.ninh.exam.entity.EmployeeEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<EmployeeEntity> getAllEmployee();
    Optional<EmployeeEntity> findById(Integer id);
    EmployeeEntity save(EmployeeEntity employee);
    public void deleteById(Integer id);
}
