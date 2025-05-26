package com.bridgelabz.employeepayrollapp.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public class EmployeePayrollDTO {
    @NotEmpty(message = "Name cannot be null")
    public String name;

    @Min(value = 500, message = "Min salary should be more than 500")
    public long salary;
}

