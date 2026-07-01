package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.dto.EmployeeDTO;
import com.example.employeemanagementsystem.projection.EmployeeProjection;
import com.example.employeemanagementsystem.projection.EmployeeValueProjection;
import com.example.employeemanagementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/projection")
    public List<EmployeeProjection> getProjection() {
        return employeeService.getProjectedEmployees();
    }
    @GetMapping("/dto")
    public List<EmployeeDTO> getDTO() {
        return employeeService.getEmployeeDTOs();
    }
    @GetMapping("/value")
    public List<EmployeeValueProjection> getValue() {
        return employeeService.getValueProjection();
    }
}
