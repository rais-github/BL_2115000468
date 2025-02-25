import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchEmployeeByName {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("employee.csv"));
             Scanner scanner = new Scanner(System.in)) 
        {
            System.out.print("Enter employee name to search: ");
            String searchName = scanner.nextLine();
            String line;
            boolean found = false;
            
            while ((line = br.readLine()) != null) {
                
                String[] employee = line.split(",");

                if(!employee[0].equals("ID"))
                {
                    String name = employee[1];
                    String department = employee[2];
                    String salary = employee[3];
                    
                    if (name.equalsIgnoreCase(searchName)) {
                        System.out.println("Department: " + department);
                        System.out.println("Salary: " + salary);
                        found = true;
                        break;
                    }
                }
                
                
            }
            if (!found) {
                    System.out.println("Employee not found.");
                }
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}
