DECLARE
    v_age NUMBER;
BEGIN
    FOR c IN (
        SELECT c.CustomerID,
               l.LoanID,
               TRUNC(MONTHS_BETWEEN(SYSDATE,c.DOB)/12) Age
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID = l.CustomerID
    )
    LOOP
        IF c.Age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = c.LoanID;
        END IF;
    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Interest rates updated');
END;
/


-- to check the result 
SELECT LoanID,
       CustomerID,
       InterestRate
FROM Loans;
