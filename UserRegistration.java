import java.util.regex.Pattern;

public class UserRegistration {

    public static void registerUser(String username, String email, String password) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }

        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format");
        }

        if (!isValidPassword(password)) {
            throw new IllegalArgumentException("Password must be at least 8 characters, contain one uppercase letter, and one digit");
        }

        // Simulating successful registration (you can add logic to store user data)
        System.out.println("User registered successfully!");
    }

    private static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email != null && Pattern.matches(emailRegex, email);
    }

    private static boolean isValidPassword(String password) {
        return password != null && password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*\\d.*");
    }
}
