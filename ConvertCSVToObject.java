import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Student{
    private int id;
    private String name;
    private float marks;
    private byte age;

    public Student(int id , String name , float marks , byte age){
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.age = age;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public float getMarks(){
        return marks;
    }

    public byte getAge(){
        return age;
    }

}

public class ConvertCSVToObject{
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("student.csv"))) {
            String line;
            
            List<Student> students = new ArrayList<>();
            while((line = br.readLine()) != null ){
                String[] values = line.split(",");
                if(!values[0].equals("ID")){
                students.add(new Student(Integer.parseInt(values[0]), values[1], Float.parseFloat(values[2]), Byte.parseByte(values[3])));
                }
            }

            for(Student student : students){
                System.out.println("ID: " + student.getId() + " Name: " + student.getName() + " Marks: " + student.getMarks() + " Age: " + student.getAge());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}