DECLARE

    CURSOR GenerateMonthlyStatements IS
        SELECT t.TransactionID,
               a.CustomerID,
               t.TransactionDate,
               t.Amount,
               t.TransactionType
        FROM Transactions t
        JOIN Accounts a
        ON t.AccountID = a.AccountID
        WHERE EXTRACT(MONTH FROM t.TransactionDate)
              = EXTRACT(MONTH FROM SYSDATE)
          AND EXTRACT(YEAR FROM t.TransactionDate)
              = EXTRACT(YEAR FROM SYSDATE);

    v_Record GenerateMonthlyStatements%ROWTYPE;

BEGIN

    OPEN GenerateMonthlyStatements;

    LOOP

        FETCH GenerateMonthlyStatements
        INTO v_Record;

        EXIT WHEN GenerateMonthlyStatements%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE(
            'Customer ID: ' || v_Record.CustomerID ||
            ', Transaction ID: ' || v_Record.TransactionID ||
            ', Amount: ' || v_Record.Amount ||
            ', Type: ' || v_Record.TransactionType
        );

    END LOOP;

    CLOSE GenerateMonthlyStatements;

END;
/
