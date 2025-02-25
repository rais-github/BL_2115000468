import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GenerateFromDB {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_username";
        String password = "your_password";
        String csvFilePath = "employee.csv";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            String sql = "SELECT employee_id, name, department, salary FROM employees";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            FileWriter fileWriter = new FileWriter(csvFilePath);
            fileWriter.append("Employee ID,Name,Department,Salary\n");

            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");
                String name = resultSet.getString("name");
                String department = resultSet.getString("department");
                double salary = resultSet.getDouble("salary");

                fileWriter.append(String.valueOf(employeeId));
                fileWriter.append(",");
                fileWriter.append(name);
                fileWriter.append(",");
                fileWriter.append(department);
                fileWriter.append(",");
                fileWriter.append(String.valueOf(salary));
                fileWriter.append("\n");
            }

            fileWriter.flush();
            fileWriter.close();
            statement.close();

            System.out.println("CSV file created successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
