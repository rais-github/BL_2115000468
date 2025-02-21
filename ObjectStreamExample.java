import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

class Employee implements Serializable{
    private int id;
    private String department;
    private String name;
    private double salary;

    public Employee(int id, String department, String name, double salary) {
        this.id = id;
        this.department = department;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", department='" + department + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }


}
public class ObjectStreamExample {
    public static void main(String[] args) {
        Employee employee = new Employee(1, "IT", "John", 1000);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(new Employee(2, "HR", "Jane", 1200));
        employees.add(new Employee(3, "Finance", "Doe", 1100));

       try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.dat"))){
           oos.writeObject(employees);
           System.out.println("Object Serialized");
       } catch (IOException e) {
           e.printStackTrace();
       } 

       try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.dat"))){
           List<Employee> employees1 = (List<Employee>) ois.readObject();
           employees1.forEach(System.out::println);
       } catch (IOException | ClassNotFoundException e) {
           e.printStackTrace();
       }
    }
}
