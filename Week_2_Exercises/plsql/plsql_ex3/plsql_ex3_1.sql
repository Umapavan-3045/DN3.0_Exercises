/
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
BEGIN
    UPDATE Accounts
    SET Balance = Balance * 1.01
       -- LastModified = SYSDATE
    WHERE AccountType = 'Savings'
      AND (SYSDATE - LastModified) >= 30;
      
    COMMIT;
END;
/
BEGIN
    ProcessMonthlyInterest;
END;
/
DECLARE
  CURSOR c_accounts IS
    SELECT CustomerID, Balance
    FROM Accounts
    WHERE AccountType = 'Savings'
      AND (SYSDATE - LastModified) >= 30;
  
  v_customerID Accounts.CustomerID%TYPE;
  v_balance Accounts.Balance%TYPE;
BEGIN
  OPEN c_accounts;
  LOOP
    FETCH c_accounts INTO v_customerID, v_balance;
    EXIT WHEN c_accounts%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(v_customerID || ' ' || v_balance);
  END LOOP;
  CLOSE c_accounts;
END;
/
