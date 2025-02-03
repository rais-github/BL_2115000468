public class Employee {
    private static String companyName = "YourCompanyName";
    private static int totalEmployees = 0;

    private final int id;
    private String name;
    private String designation;

    public Employee(int id){
        this.id = id;
        this.name = "";
        this.designation = "";
        totalEmployees++;
    }

    public Employee(int id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        totalEmployees++;
    }

    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    public void printEmployeeDetails(Object obj) {
        if (obj instanceof Employee) {
            Employee emp = (Employee) obj;
            System.out.println("Employee ID: " + emp.getId());
            System.out.println("Employee Name: " + emp.getName());
            System.out.println("Employee Designation: " + emp.getDesignation());
            System.out.println("Company Name: " + companyName);
        } else {
            System.out.println("The provided object is not an instance of Employee.");
        }
    }

    

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee(1);
        emp1.setName("John Doe");
        emp1.setDesignation("Software Developer");
        Employee emp2 = new Employee(2, "Jane Smith", "Project Manager");

        emp1.printEmployeeDetails(emp1);
        emp2.printEmployeeDetails(emp2);

        Employee.displayTotalEmployees();
    }
}