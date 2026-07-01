package com.example.employeemanagementsystem.projection;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeValueProjection {

    @Value("#{target.name}")
    String getEmployeeName();

    @Value("#{target.email}")
    String getEmployeeEmail();
}
