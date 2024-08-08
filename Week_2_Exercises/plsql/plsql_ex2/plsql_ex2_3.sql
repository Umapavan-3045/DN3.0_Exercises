
CREATE OR REPLACE PROCEDURE AddNewCustomer(
    CusID IN NUMBER,
    CusName IN VARCHAR2,
    CusDOB IN DATE,
    CusBalance IN NUMBER,
    CusLastModified IN DATE
)
IS
  Invalid_Customer_ID EXCEPTION;
  Customer_Count NUMBER;
BEGIN
  SELECT count(*) INTO Customer_Count FROM Customers WHERE CustomerID = CusID;
  
  IF Customer_Count > 0 THEN
    RAISE Invalid_Customer_ID;
  END IF;
  
  INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
  VALUES (CusID, CusName, CusDOB, CusBalance, CusLastModified);
  
  DBMS_OUTPUT.PUT_LINE('Customer registered Successfully');
  
EXCEPTION
  WHEN Invalid_Customer_ID THEN
    DBMS_OUTPUT.PUT_LINE('Invalid Customer ID');
END;
/


BEGIN
AddNewCustomer(CusID=>1,CusName=>'umapavan',CusDOB=>SYSDATE,CusBalance=>5000,CusLastModified=>SYSDATE);
END;
/
