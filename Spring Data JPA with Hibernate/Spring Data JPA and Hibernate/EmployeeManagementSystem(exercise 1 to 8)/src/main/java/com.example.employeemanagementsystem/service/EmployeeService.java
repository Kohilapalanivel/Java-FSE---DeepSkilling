package com.example.employeemanagementsystem.service;

import com.example.employeemanagementsystem.dto.EmployeeDTO;
import com.example.employeemanagementsystem.projection.EmployeeProjection;
import com.example.employeemanagementsystem.projection.EmployeeValueProjection;
import com.example.employeemanagementsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Interface Projection
    public List<EmployeeProjection> getProjectedEmployees() {
        return employeeRepository.getProjectedEmployees();
    }

    // DTO Projection
    public List<EmployeeDTO> getEmployeeDTOs() {
        return employeeRepository.getEmployeeDTO();
    }

    // Value Projection
    public List<EmployeeValueProjection> getValueProjection() {
        return employeeRepository.getValueProjection();
    }
}
