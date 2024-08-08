DECLARE
  v_age NUMBER;
  new Loans.InterestRate%type;
BEGIN
  FOR rec IN (
    SELECT c.CustomerID AS CustID, c.DOB, l.LoanID, l.InterestRate
    FROM Customers c
    JOIN Loans l ON c.CustomerID = l.CustomerID
  ) LOOP
    v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12);
    IF v_age > 60 THEN
      UPDATE Loans
      SET InterestRate = InterestRate -1
      WHERE LoanID = rec.LoanID;
      select InterestRate into new from Loans l where  l.CustomerID=rec.CustID;
      DBMS_OUTPUT.PUT_LINE('Applied 1% discount to Customer ID: ' || rec.CustID || ', New Interest Rate: ' || (rec.InterestRate) || 'NEW INterest '||new);
    END IF;
  END LOOP;
  
  
END;
/