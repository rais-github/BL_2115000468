import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ValidateCSV {
    public static void main(String[] args) {
        String csvFile = "data.csv"; 
        String line;
        String csvSplitBy = ",";

        // Regex patterns for validation
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        String phoneRegex = "^[0-9]{10}$";

        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(csvSplitBy);

                // Assuming email is in the first column and phone number is in the second column
                String email = columns[0];
                String phoneNumber = columns[1];

                Matcher emailMatcher = emailPattern.matcher(email);
                Matcher phoneMatcher = phonePattern.matcher(phoneNumber);

                if (!emailMatcher.matches()) {
                    System.out.println("Invalid email: " + email);
                }

                if (!phoneMatcher.matches()) {
                    System.out.println("Invalid phone number: " + phoneNumber);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
