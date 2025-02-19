import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }
}

enum Department {
    HR, IT, SALES, MARKETING
}

public class GroupObjectByProperty {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", Department.IT),
            new Employee("Bob", Department.HR),
            new Employee("Charlie", Department.IT),
            new Employee("David", Department.SALES),
            new Employee("Eve", Department.MARKETING)
        );

        Map<Department, List<Employee>> employeesByDepartment = employees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment));

        employeesByDepartment.forEach((department, empList) -> {
            System.out.println(department);
            empList.forEach(emp -> System.out.println(" - " + emp.getName()));
        });
    }
}