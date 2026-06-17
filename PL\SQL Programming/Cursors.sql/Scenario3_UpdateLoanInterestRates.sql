DECLARE
    CURSOR UpdateLoanInterestRates IS
        SELECT LoanID
        FROM Loans;
    v_LoanID Loans.LoanID%TYPE;
BEGIN
    OPEN UpdateLoanInterestRates;
    LOOP
        FETCH UpdateLoanInterestRates
        INTO v_LoanID;
        EXIT WHEN UpdateLoanInterestRates%NOTFOUND;
        UPDATE Loans
        SET InterestRate = InterestRate + 0.5
        WHERE LoanID = v_LoanID;
    END LOOP;
    CLOSE UpdateLoanInterestRates;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Loan Interest Rates Updated');
END;
/
