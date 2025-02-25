import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ModifyCSV{
    public static void main(String[] args) {
        String inputFilePath = "employee.csv";
        String outputFilePath = "updated_employee.csv";
        String line;
        String csvSplitBy = ",";
        String[] headers;

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {

            // Read the header
            if ((line = br.readLine()) != null) {
               headers = line.split(csvSplitBy);
               bw.write(String.join(csvSplitBy, headers));
               bw.newLine();
            }

            // Read and process each line
            while ((line = br.readLine()) != null) {
               String[] employee = line.split(csvSplitBy);
               if ("IT".equals(employee[2])) { 
                  double salary = Double.parseDouble(employee[3]); 
                  salary *= 1.10; 
                  employee[3] = String.valueOf(salary);
               }
               bw.write(String.join(csvSplitBy, employee));
               bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}