import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidateHexCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a hex color code:");
        String input = scanner.nextLine();

        String hexPattern = "^#([A-Fa-f0-9]{6})$";
        boolean isValid = Pattern.matches(hexPattern, input);

        if (isValid) {
            System.out.println("Valid hex color code.");
        } else {
            System.out.println("Invalid hex color code.");
        }

        scanner.close();
    }
}
