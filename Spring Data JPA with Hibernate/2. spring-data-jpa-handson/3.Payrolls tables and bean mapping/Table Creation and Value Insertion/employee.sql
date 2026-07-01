CREATE TABLE employee (
    em_id INT AUTO_INCREMENT PRIMARY KEY,
    em_name VARCHAR(100) NOT NULL,
    em_salary DOUBLE,
    em_permanent BOOLEAN,
    em_date_of_birth DATE,
    em_dp_id INT,
    CONSTRAINT fk_employee_department
        FOREIGN KEY (em_dp_id)
        REFERENCES department(dp_id)
);
