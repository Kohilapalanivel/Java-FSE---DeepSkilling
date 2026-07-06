package com.cognizant.springlearn.dao;
import java.util.ArrayList;
import java.util.Iterator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@Repository
public class EmployeeDao {

    private static ArrayList<Employee> EMPLOYEE_LIST;

    @SuppressWarnings("unchecked")
    public EmployeeDao() {
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        EMPLOYEE_LIST = (ArrayList<Employee>) context.getBean("employeeList");
    }

    public ArrayList<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }

    public void updateEmployee(Employee employee) throws EmployeeNotFoundException {

        boolean found = false;

        for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {

            Employee emp = EMPLOYEE_LIST.get(i);

            if (emp.getId() == employee.getId()) {
                EMPLOYEE_LIST.set(i, employee);
                found = true;
                break;
            }
        }

        if (!found) {
            throw new EmployeeNotFoundException("Employee Not Found");
        }
    }

    public void deleteEmployee(int id) throws EmployeeNotFoundException {

        Iterator<Employee> iterator = EMPLOYEE_LIST.iterator();

        while (iterator.hasNext()) {

            Employee employee = iterator.next();

            if (employee.getId() == id) {
                iterator.remove();
                return;
            }
        }

        throw new EmployeeNotFoundException("Employee Not Found");
    }
}
