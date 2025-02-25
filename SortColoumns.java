import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SortColoumns {
    public static void main(String[] args) {
        String inputFilePath = "employee.csv";
        String outputFilePath = "updated_employee.csv";
        String line;
        String csvSplitBy = ",";
        String[] headers;
        ArrayList<String[]> employees = new ArrayList<>();

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
                employees.add(employee);
            }

            // Sort employees by salary in descending order
            employees.sort((e1, e2) -> Integer.parseInt(e2[3]) - Integer.parseInt(e1[3]));

            // Write sorted employees to the output file
            for (String[] employee : employees) {
                bw.write(String.join(csvSplitBy, employee));
                bw.newLine();
            }

            // Print the top 5 highest-paid employees
            System.out.println("Top 5 highest-paid employees:");
            for (int i = 0; i < Math.min(5, employees.size()); i++) {
                String[] employee = employees.get(i);
                System.out.println(String.join(csvSplitBy, employee));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
