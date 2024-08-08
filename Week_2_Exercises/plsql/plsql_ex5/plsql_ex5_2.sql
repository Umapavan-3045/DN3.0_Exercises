/
BEGIN
  EXECUTE IMMEDIATE 'CREATE TABLE AuditLog (
    AuditID NUMBER PRIMARY KEY,
    TransactionID NUMBER,
    TransactionDate DATE,
    Amount NUMBER,
    TransactionType VARCHAR2(10),
    ActionDate DATE
  )';
END;
/

BEGIN
  EXECUTE IMMEDIATE 'CREATE SEQUENCE AuditLog_SEQ
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE';
END;
/

CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
  INSERT INTO AuditLog (AuditID, TransactionID, TransactionDate, Amount, TransactionType, ActionDate)
  VALUES (AuditLog_SEQ.NEXTVAL, :NEW.TransactionID, :NEW.TransactionDate, :NEW.Amount, :NEW.TransactionType, SYSDATE);
END;
/