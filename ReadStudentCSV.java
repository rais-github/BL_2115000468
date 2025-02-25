import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadStudentCSV{
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("student.csv"))) {
            String line;
            while((line = br.readLine()) != null){
                String[] values = line.split(",");
                System.out.println("ID: "+values[0]+" Name: "+values[1]+" Age: "+values[2]+" Marks: "+values[3]);  
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}