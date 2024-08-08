CREATE OR REPLACE PROCEDURE SafeTransferFunds(
  acc1 IN Accounts.AccountID%TYPE,
  acc2 IN Accounts.AccountID%TYPE,
  amount IN Accounts.Balance%TYPE
)
IS
  Funds_Insufficient EXCEPTION;
  From_Acc_Balance Accounts.Balance%TYPE;
BEGIN
  -- Retrieve balance from the source account
  SELECT Balance INTO From_Acc_Balance FROM Accounts WHERE AccountID = acc1;
  IF From_Acc_Balance < amount THEN
    RAISE Funds_Insufficient;
  END IF;

  DBMS_OUTPUT.PUT_LINE('*** TRANSFER DONE SUCCESSFULLY ***');
  
EXCEPTION
  WHEN Funds_Insufficient THEN 
    DBMS_OUTPUT.PUT_LINE('*** INSUFFICIENT AMOUNT ***');
END;
/
BEGIN
  SafeTransferFunds(acc1 => 1, acc2 => 2, amount => 500);
END;
/
