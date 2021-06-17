package com.example.ninh.exam.service;

import com.example.ninh.exam.entity.EmployeeEntity;
import com.example.ninh.exam.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeEntity> getAllEmployee() {
        List<EmployeeEntity> employee = employeeRepository.findAll();
        return employee;
    }

    @Override
    public Optional<EmployeeEntity> findById(Integer id) {
        return employeeRepository.findById(id);
    }

    @Override
    public EmployeeEntity save(EmployeeEntity employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }
}
