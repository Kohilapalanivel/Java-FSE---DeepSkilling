BEGIN
    FOR c IN (
        SELECT CustomerID, Balance
        FROM Customers
    )
    LOOP
        IF c.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = c.CustomerID;
        END IF;
    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('VIP status updated successfully');
END;
/
-- to view the result
SELECT CustomerID, Name, Balance, IsVIP
FROM Customers;
