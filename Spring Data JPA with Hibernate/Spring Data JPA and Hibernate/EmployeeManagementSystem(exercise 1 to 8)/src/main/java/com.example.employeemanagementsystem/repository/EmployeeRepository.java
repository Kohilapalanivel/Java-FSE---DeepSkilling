package com.example.employeemanagementsystem.repository;

import com.example.employeemanagementsystem.dto.EmployeeDTO;
import com.example.employeemanagementsystem.entity.Employee;
import com.example.employeemanagementsystem.projection.EmployeeProjection;
import com.example.employeemanagementsystem.projection.EmployeeValueProjection;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT new com.example.employeemanagementsystem.dto.EmployeeDTO(e.name, e.email) FROM Employee e")
    List<EmployeeDTO> getEmployeeDTO();
    @Query("SELECT e FROM Employee e")
    List<EmployeeProjection> getProjectedEmployees();
    @Query("SELECT e FROM Employee e")
    List<EmployeeValueProjection> getValueProjection();
    @Query("SELECT e FROM Employee e WHERE e.email LIKE %:keyword%")
    List<Employee> searchByEmail(@Param("keyword") String keyword);
}
