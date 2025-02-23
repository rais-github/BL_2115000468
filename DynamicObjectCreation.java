import java.lang.reflect.Constructor;
class Student {
    private String name;


    public Student(String name) {
        this.name = name;
    }
    public void display() {
        System.out.println("Student Name: " + name);
    }
}

public class DynamicObjectCreation {
    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName("Student");
            Constructor<?> cons = c.getConstructor(String.class);
            Student s = (Student) cons.newInstance("John");
            s.display();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
 
