import React from "react";
import EmployeeCard from "./EmployeeCard";
import Employee from "./Employee";

function EmployeesList() {
  const employees = [
    new Employee(101, "John", "Developer"),
    new Employee(102, "Alice", "Tester"),
    new Employee(103, "David", "Manager")
  ];

  return (
    <div>
      {employees.map((employee) => (
        <EmployeeCard
          key={employee.id}
          employee={employee}
        />
      ))}
    </div>
  );
}

export default EmployeesList;
