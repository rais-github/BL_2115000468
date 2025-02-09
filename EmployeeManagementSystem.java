interface Department {
    void assignDepartment(String departmentName);
    String getDepartmentDetails();
}

abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("Employee ID: " + this.employeeId);
        System.out.println("Name: " + this.name);
        System.out.println("Base Salary: " + this.baseSalary);
        System.out.println("Total Salary: " + this.calculateSalary());
    }
}

class FullTimeEmployee extends Employee {
    private double fixedSalary;

    public FullTimeEmployee(int employeeId, String name, double baseSalary, double fixedSalary) {
        super(employeeId, name, baseSalary);
        this.fixedSalary = fixedSalary;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + fixedSalary;
    }
}

class PartTimeEmployee extends Employee {
    private int workHours;
    private double hourlyRate;

    public PartTimeEmployee(int employeeId, String name, double baseSalary, int workHours, double hourlyRate) {
        super(employeeId, name, baseSalary);
        this.workHours = workHours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + (workHours * hourlyRate);
    }
}


class EmployeeFactory {
    public static Employee createEmployee(String type, int employeeId, String name, double baseSalary, double... additionalParams) {
        switch (type) {
            case "FullTime":
                return new FullTimeEmployee(employeeId, name, baseSalary, additionalParams[0]);
            case "PartTime":
                return new PartTimeEmployee(employeeId, name, baseSalary, (int) additionalParams[0], additionalParams[1]);
            default:
                throw new IllegalArgumentException("Invalid employee type");
        }
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee emp1 = EmployeeFactory.createEmployee("FullTime", 1, "John Doe", 50000, 20000);
        Employee emp2 = EmployeeFactory.createEmployee("PartTime", 2, "Jane Smith", 30000, 20, 100);

        emp1.displayDetails();
        emp2.displayDetails();
    }
}