/
CREATE OR REPLACE PROCEDURE TransferFunds(
    sendingAcc IN INT,
    receiveAcc IN INT,
    Amount IN INT
) 
AS
    funds NUMBER;
BEGIN
    SELECT Balance INTO funds 
    FROM Accounts 
    WHERE AccountID = sendingAcc 
    FOR UPDATE;
    
    IF Amount > funds THEN 
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient Balance');
    END IF;
   
    UPDATE Accounts 
    SET Balance = Balance - Amount, LastModified = SYSDATE
    WHERE AccountID = sendingAcc;
    
    UPDATE Accounts 
    SET Balance = Balance + Amount, LastModified = SYSDATE
    WHERE AccountID = receiveAcc;
  
    COMMIT;
END;
/
DECLARE
    CURSOR acc_cursor IS
        SELECT AccountID, Balance, LastModified
        FROM Accounts
        WHERE AccountID IN (1, 2); 
    acc_rec acc_cursor%ROWTYPE;
BEGIN
    TransferFunds(1, 2, 500);

     OPEN acc_cursor;
    
       LOOP
        FETCH acc_cursor INTO acc_rec;
        EXIT WHEN acc_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('AccountID: ' || acc_rec.AccountID || 
                             ', Balance: ' || acc_rec.Balance ||
                             ', LastModified: ' || acc_rec.LastModified);
    END LOOP;
    
        CLOSE acc_cursor;
END;
/
