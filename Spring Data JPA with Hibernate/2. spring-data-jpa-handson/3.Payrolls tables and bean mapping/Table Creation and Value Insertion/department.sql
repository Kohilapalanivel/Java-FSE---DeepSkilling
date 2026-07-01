USE ormlearn;
CREATE TABLE department (
    dp_id INT AUTO_INCREMENT PRIMARY KEY,
    dp_name VARCHAR(100) NOT NULL
);

INSERT INTO department(dp_name) VALUES ('IT'),('HR'),('Finance');
