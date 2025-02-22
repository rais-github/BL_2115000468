import java.util.Scanner;

public class ValidateLicensePlate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a license plate number: ");
        String licensePlate = scanner.nextLine();
        if (licensePlate.matches("[A-Z]{2}[0-9]{4}")) {
            System.out.println("Valid license plate number.");
        } else {
            System.out.println("Invalid license plate number.");
        }
        scanner.close();
    }
}
