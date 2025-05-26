package com.bridgelabz.employeepayrollapp.service.impl;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.IEmployeePayrollRepository;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    @Autowired
    private IEmployeePayrollRepository repo;

    public List<EmployeePayrollData> getEmployeePayrollData() {
        return repo.findAll();
    }

    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return repo.findById(empId).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO dto) {
        return repo.save(new EmployeePayrollData(dto));
    }

    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO dto) {
        EmployeePayrollData data = this.getEmployeePayrollDataById(empId);
        data.setName(dto.name);
        data.setSalary(dto.salary);
        return repo.save(data);
    }

    public void deleteEmployeePayrollData(int empId) {
        repo.deleteById(empId);
    }
}

