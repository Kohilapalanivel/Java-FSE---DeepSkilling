CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT
ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog
    VALUES (
        :NEW.TransactionID,
        :NEW.TransactionID,
        SYSDATE,
        'Transaction Recorded'
    );
END;
/
