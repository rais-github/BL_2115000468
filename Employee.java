import java.util.Scanner;

public class Employee{
    private int id;
    private String name;
    private double salary;

    public Employee(){
        this.id = 0;
        this.name = "";
        this.salary = 0.0;
    }
    public Employee(int _id,String _name,double _salary){
        this.id = _id;
        this.name = _name;
        this.salary = _salary;
    }

    public void setId(int _id){
        this.id = _id;
    }

    public void setName(String _name){
        this.name = _name;
    }

    public void setSalary(double _salary){
        this.salary = _salary;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public double getSalary(){
        return this.salary;
    }

    public void showEmployeeDetails(){
        System.out.println("Employee ID: "+this.id);
        System.out.println("Employee Name: "+this.name);
        System.out.println("Employee Salary: "+this.salary);
    }   

    public static void main(String[] args) {
        
        System.out.println("Enter the details of the employee");

        Employee emp = new Employee();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the ID of the employee");

        emp.setId(sc.nextInt());

        System.out.println("Enter the Name of the employee");

        emp.setName(sc.next());

        System.out.println("Enter the Salary of the employee");
        
        emp.setSalary(sc.nextDouble());

        emp.showEmployeeDetails();

        sc.close();

    }

    
}