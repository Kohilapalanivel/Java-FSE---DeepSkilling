CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_LoanAmount NUMBER,
    p_InterestRate NUMBER,
    p_Years NUMBER
)
RETURN NUMBER
IS
    v_TotalAmount NUMBER;
    v_MonthlyInstallment NUMBER;
BEGIN

    v_TotalAmount :=
    p_LoanAmount +
    (p_LoanAmount * p_InterestRate * p_Years / 100);

    v_MonthlyInstallment :=
    v_TotalAmount / (p_Years * 12);

    RETURN ROUND(v_MonthlyInstallment,2);

END;
/
