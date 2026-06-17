DECLARE
    CURSOR ApplyAnnualFee IS
        SELECT AccountID
        FROM Accounts;
    v_AccountID Accounts.AccountID%TYPE;
BEGIN
    OPEN ApplyAnnualFee;
    LOOP
        FETCH ApplyAnnualFee
        INTO v_AccountID;
        EXIT WHEN ApplyAnnualFee%NOTFOUND;
        UPDATE Accounts
        SET Balance = Balance - 100
        WHERE AccountID = v_AccountID;
    END LOOP;
    CLOSE ApplyAnnualFee;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Annual Fee Applied');
END;
/
