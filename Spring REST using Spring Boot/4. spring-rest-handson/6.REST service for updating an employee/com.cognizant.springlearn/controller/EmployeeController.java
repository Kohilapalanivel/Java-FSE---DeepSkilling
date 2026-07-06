package com.cognizant.springlearn.controller;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;
import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.EmployeeService;
@RestController
@RequestMapping("/employees")
public class EmployeeController 
{
    @Autowired
    private EmployeeService employeeService;
    @GetMapping
    public ArrayList<Employee> getAllEmployees()
    {
        return employeeService.getAllEmployees();
    }
    @PutMapping
    public void updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException 
    {
        employeeService.updateEmployee(employee);
    }
}
