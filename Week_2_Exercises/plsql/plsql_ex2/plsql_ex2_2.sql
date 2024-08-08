CREATE OR REPLACE PROCEDURE UpdateSalary(
  EmpID IN Employees.EmployeeID%TYPE,
  SalInc IN NUMBER
)
IS
  Invalid_Employee_ID EXCEPTION;
  Employee_Count NUMBER;
BEGIN
  SELECT count(*) INTO Employee_Count FROM Employees WHERE EmployeeID = EmpID;
  
  IF Employee_Count < 1 THEN
    RAISE Invalid_Employee_ID;
  END IF;
  
  UPDATE Employees
  SET Salary = Salary + (Salary * SalInc * 0.01)
  WHERE EmployeeID = EmpID;
  
  DBMS_OUTPUT.PUT_LINE('Salary Updated Successfully');
  
EXCEPTION
  WHEN Invalid_Employee_ID THEN
    DBMS_OUTPUT.PUT_LINE('Invalid Employee ID');
END;
/

BEGIN
UpdateSalary(EmpID=>4,SalInc=>5);
END;
/