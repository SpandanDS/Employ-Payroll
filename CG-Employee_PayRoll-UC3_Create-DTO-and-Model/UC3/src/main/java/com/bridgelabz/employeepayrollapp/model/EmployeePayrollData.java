package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import jakarta.persistence.*;

@Entity
public class EmployeePayrollData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private long salary;

    public EmployeePayrollData() {}

    public EmployeePayrollData(EmployeePayrollDTO dto) {
        this.name = dto.name;
        this.salary = dto.salary;
    }

    public void setName(String name) { this.name = name; }
    public void setSalary(long salary) { this.salary = salary; }

    public int getId() { return id; }
    public String getName() { return name; }
    public long getSalary() { return salary; }
}
