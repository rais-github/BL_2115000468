import java.util.regex.*;
public class ExtractEmail {
    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org";

        String emailPattern = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Email: " + matcher.group());
        }
    }
}
