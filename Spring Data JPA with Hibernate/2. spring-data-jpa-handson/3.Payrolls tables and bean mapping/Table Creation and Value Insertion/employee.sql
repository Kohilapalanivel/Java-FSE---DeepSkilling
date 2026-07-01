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
INSERT INTO employee
(em_name, em_salary, em_permanent, em_date_of_birth, em_dp_id)
VALUES
('John',50000,TRUE,'1998-05-20',1),
('David',60000,TRUE,'1996-02-15',2),
('Priya',45000,FALSE,'2000-09-10',1);
