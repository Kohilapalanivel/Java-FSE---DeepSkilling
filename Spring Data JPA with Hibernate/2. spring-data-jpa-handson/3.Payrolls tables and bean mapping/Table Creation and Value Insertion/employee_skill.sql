CREATE TABLE employee_skill (
    es_em_id INT,
    es_sk_id INT,
    PRIMARY KEY (es_em_id, es_sk_id),

    CONSTRAINT fk_employee_skill_employee
        FOREIGN KEY (es_em_id)
        REFERENCES employee(em_id),

    CONSTRAINT fk_employee_skill_skill
        FOREIGN KEY (es_sk_id)
        REFERENCES skill(sk_id)
);
INSERT INTO employee_skill VALUES(1,1),(1,2),(1,3),(2,3),(3,1),(3,4);
