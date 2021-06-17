package com.example.ninh.exam.controller.api;


import com.example.ninh.exam.entity.EmployeeEntity;
import com.example.ninh.exam.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiAdminController {

    @Autowired
    EmployeeService employeeService;

    //Lay danh sach
    @GetMapping("/employee")
    public ResponseEntity<List<EmployeeEntity>> getAllEmployee(@ModelAttribute EmployeeEntity employeeEntity){
        List<EmployeeEntity> employee = employeeService.getAllEmployee();
        if (employee != null){
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //lay 1 danh sach
    @GetMapping("/employee/{id}")
    public ResponseEntity<Optional<EmployeeEntity>> getOneEmployee(@PathVariable("id") Integer id ){
        Optional<EmployeeEntity> employee = employeeService.findById(id);
        if (employee.isPresent()){
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Them 1 nhan vien
    @PostMapping("/employee")
    public ResponseEntity<EmployeeEntity> addEmployee(@RequestBody EmployeeEntity employeeEntity){
        try {
            employeeService.save(employeeEntity);
            return new ResponseEntity<>(employeeEntity, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Sua danh sach
    @PutMapping("/employee/{id}")
    public ResponseEntity<Optional<EmployeeEntity>> editEmployee(@PathVariable("id") Integer id,
                                                           @RequestBody EmployeeEntity employeeEntity)
    {
        Optional<EmployeeEntity> update =employeeService.findById(id);
        if (update.isPresent()){
            EmployeeEntity employee = update.get();
            employee.setName(employeeEntity.getName());
            employee.setSalary(employeeEntity.getSalary());

            employeeService.save(employee);
                return new ResponseEntity<>(update, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
//
    //Xoa nhan vien
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Optional<EmployeeEntity>> deleteEmployee(@PathVariable("id") Integer id){
        Optional<EmployeeEntity> employee = employeeService.findById(id);
        if (employee.isPresent()){
            employeeService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
