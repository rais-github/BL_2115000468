import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ValidateUsername{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the username");
        String username = scanner.nextLine();
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(username);
        if(matcher.matches()){
            System.out.println("Username is valid");
        }else{
            System.out.println("Username is invalid");
        }
        scanner.close();
    }
}