import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterRecords {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("student.csv"))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            if(!values[3].equals("Marks") && Integer.parseInt(values[3]) > 80) {
                System.out.println(values[0] + " " + values[1] + " " + values[2] + " " + values[3]);
            }
        }            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
