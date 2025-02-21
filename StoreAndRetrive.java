import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


        public class StoreAndRetrive {
            public static void main(String[] args) {
                String filename = "students.dat";

                
                try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
                    dos.writeInt(1); 
                    dos.writeUTF("John Doe");
                    dos.writeDouble(3.5); 

                    dos.writeInt(2); 
                    dos.writeUTF("Jane Smith"); 
                    dos.writeDouble(3.8); 
                } catch (IOException e) {
                    System.err.println("Error writing to file: " + e.getMessage());
                }

                // Retrieve student details
                try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
                    while (dis.available() > 0) {
                        int rollNumber = dis.readInt();
                        String name = dis.readUTF();
                        double gpa = dis.readDouble();
                        System.out.println("Roll Number: " + rollNumber + ", Name: " + name + ", GPA: " + gpa);
                    }
                } catch (IOException e) {
                    System.err.println("Error reading from file: " + e.getMessage());
                }
            }
        }
 