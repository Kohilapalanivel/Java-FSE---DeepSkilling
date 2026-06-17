CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_CustomerID NUMBER,
    p_Name VARCHAR2,
    p_DOB DATE,
    p_Balance NUMBER
)
IS
BEGIN

    INSERT INTO Customers
    (CustomerID, Name, DOB, Balance, LastModified)
    VALUES
    (p_CustomerID, p_Name, p_DOB, p_Balance, SYSDATE);

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Customer Added');

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE('Customer ID already exists');

    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE(SQLERRM);
END;
/
