package com.example.employeemanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeemanagementsystem.entity.Department;
import com.example.employeemanagementsystem.repository.DepartmentRepository;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    public Department updateDepartment(Long id, Department department) {
    	System.out.println(department.getId());
        return departmentRepository.save(department);
    }
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

}
