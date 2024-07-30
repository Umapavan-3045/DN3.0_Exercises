public class Employee {
    private int employeeId;
    private String name;
    private String position;
    private double salary;
    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public String getName() {
        return name;
    }
    public String getPosition() {
        return position;
    }
    public double getSalary() {
        return salary;
    } 
@Override
    public String toString() {
        return "Employee ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: $" + salary;
    }
}
public class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;
    public EmployeeManager(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }
    // Add an employee to the list
    public void addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size++] = employee;
        } else {
            System.out.println("Array is full. Cannot add more employees.");
        }
    }
    // Search for an employee by ID
    public Employee searchEmployeeById(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }
    // Traverse and print all employees
    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }
    // Delete an employee by ID
    public boolean deleteEmployeeById(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--size] = null;
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(10);
        // Adding sample employees
        manager.addEmployee(new Employee(1, "Alice", "Developer", 70000));
        manager.addEmployee(new Employee(2, "Bob", "Manager", 85000));
        manager.addEmployee(new Employee(3, "Charlie", "Analyst", 60000));
        manager.addEmployee(new Employee(4, "David", "Designer", 65000));
        System.out.println("All employees:");
        manager.traverseEmployees(); // Traversing and printing employees 
        System.out.println("\nSearching for employee with ID 3:");
        Employee employee = manager.searchEmployeeById(3); // Searching for an employee by ID
        if (employee != null) {
            System.out.println("Found: " + employee);
        } else {
            System.out.println("Employee not found.");
        }
        System.out.println("\nDeleting employee with ID 2:");
        boolean isDeleted = manager.deleteEmployeeById(2);        // Deleting an employee by ID
        System.out.println("Deleted: " + isDeleted);
        // Traversing and printing employees after deletion
        System.out.println("\nAll employees after deletion:");
        manager.traverseEmployees();
    }
}
