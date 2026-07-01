package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.EmployeeService;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static EmployeeService employeeService;

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

        employeeService = context.getBean(EmployeeService.class);

        // Hands-on 2
        // testGetAllPermanentEmployees();

        // Hands-on 4
        testGetAverageSalary();
    }

    private static void testGetAllPermanentEmployees() {

        LOGGER.info("Start");

        List<Employee> employees =  employeeService.getAllPermanentEmployees();

        LOGGER.debug("Permanent Employees : {}", employees);

        employees.forEach(employee ->
                LOGGER.debug("Skills : {}", employee.getSkillList()));

        LOGGER.info("End");
    }

    private static void testGetAverageSalary() {

        LOGGER.info("Start");

        double averageSalary = employeeService.getAverageSalary(2);

        LOGGER.debug("Average Salary : {}", averageSalary);

        LOGGER.info("End");
    }
}
