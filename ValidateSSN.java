import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateSSN {
    public static void main(String[] args) {
        String input = "My SSN is 123-45-6789.";
        String ssn = extractSSN(input);
        
        if (ssn != null && isValidSSN(ssn)) {
            System.out.println("✅ \"" + ssn + "\" is valid");
        } else {
            System.out.println("❌ \"" + ssn + "\" is invalid");
        }
    }

    private static String extractSSN(String input) {
        Pattern pattern = Pattern.compile("\\b\\d{3}-\\d{2}-\\d{4}\\b");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    private static boolean isValidSSN(String ssn) {
        return ssn.matches("\\d{3}-\\d{2}-\\d{4}");
    }
}