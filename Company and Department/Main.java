import java.util.ArrayList;
import java.util.List;

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public String getName() {
        return name;
    }
}

class Company {
    private String name;
    private List<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public String getName() {
        return name;
    }

    
}

public class Main {
    public static void main(String[] args) {
        Company company = new Company("TechCorp");

        Department hr = new Department("HR");
        hr.addEmployee(new Employee("Alice"));
        hr.addEmployee(new Employee("Bob"));

        Department it = new Department("IT");
        it.addEmployee(new Employee("Charlie"));
        it.addEmployee(new Employee("Dave"));

        company.addDepartment(hr);
        company.addDepartment(it);

        System.out.println("Company: " + company.getName());
        for (Department dept : company.getDepartments()) {
            System.out.println("Department: " + dept.getName());
            for (Employee emp : dept.getEmployees()) {
                System.out.println("Employee: " + emp.getName());
            }
        }

        // Simulate deleting the company
        company = null;
        System.gc(); // Request garbage collection
    }
}