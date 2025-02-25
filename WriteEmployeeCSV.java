import java.io.*;
public class WriteEmployeeCSV {
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("employee.csv"))) {
            writer.write("ID,Name,Department,Salary\n");
            
            writer.write("104,Alice Williams,Finance,62000\n");
            writer.write("105,Himanshu Rai,Engineering,42000\n");
            writer.write("106,Cunute,Management,92000\n");
            writer.write("107,Trevor Scot,Singer,50000\n");
            writer.write("108,Bob Johnson,Sales,58000\n");

            System.out.println("CSV file written successfully!");

            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
