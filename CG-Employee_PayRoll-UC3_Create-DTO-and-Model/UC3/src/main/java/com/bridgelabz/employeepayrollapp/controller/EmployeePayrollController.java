package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService service;

    @GetMapping("/")
    public ResponseEntity<List<EmployeePayrollData>> getAllEmployees() {
        return ResponseEntity.ok(service.getEmployeePayrollData());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeePayrollData> getEmployeeById(@PathVariable int id) {
        return ResponseEntity.ok(service.getEmployeePayrollDataById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<EmployeePayrollData> addEmployee(@Valid @RequestBody EmployeePayrollDTO dto) {
        return ResponseEntity.ok(service.createEmployeePayrollData(dto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeePayrollData> updateEmployee(@PathVariable int id, @Valid @RequestBody EmployeePayrollDTO dto) {
        return ResponseEntity.ok(service.updateEmployeePayrollData(id, dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        service.deleteEmployeePayrollData(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
}
