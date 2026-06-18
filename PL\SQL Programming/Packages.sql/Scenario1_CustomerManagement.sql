CREATE OR REPLACE PACKAGE CustomerManagement AS

    PROCEDURE AddCustomer(
        p_CustomerID NUMBER,
        p_Name VARCHAR2,
        p_DOB DATE,
        p_Balance NUMBER
    );

    PROCEDURE UpdateCustomer(
        p_CustomerID NUMBER,
        p_Name VARCHAR2
    );

    FUNCTION GetCustomerBalance(
        p_CustomerID NUMBER
    ) RETURN NUMBER;

END CustomerManagement;
/


CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    PROCEDURE AddCustomer(
        p_CustomerID NUMBER,
        p_Name VARCHAR2,
        p_DOB DATE,
        p_Balance NUMBER
    )
    IS
    BEGIN
        INSERT INTO Customers
        (
            CustomerID,
            Name,
            DOB,
            Balance,
            IsVIP,
            LastModified
        )
        VALUES
        (
            p_CustomerID,
            p_Name,
            p_DOB,
            p_Balance,
            'FALSE',
            SYSDATE
        );

        COMMIT;
    END AddCustomer;


    PROCEDURE UpdateCustomer(
        p_CustomerID NUMBER,
        p_Name VARCHAR2
    )
    IS
    BEGIN
        UPDATE Customers
        SET Name = p_Name
        WHERE CustomerID = p_CustomerID;

        COMMIT;
    END UpdateCustomer;


    FUNCTION GetCustomerBalance(
        p_CustomerID NUMBER
    )
    RETURN NUMBER
    IS
        v_Balance NUMBER;
    BEGIN
        SELECT Balance
        INTO v_Balance
        FROM Customers
        WHERE CustomerID = p_CustomerID;

        RETURN v_Balance;
    END GetCustomerBalance;

END CustomerManagement;
/
