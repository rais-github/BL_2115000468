import java.util.Scanner;

public class L1_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of side 1 (in meters): ");
        double side1 = scanner.nextDouble();
        System.out.print("Enter the length of side 2 (in meters): ");
        double side2 = scanner.nextDouble();
        System.out.print("Enter the length of side 3 (in meters): ");
        double side3 = scanner.nextDouble();

        double rounds = calculateRounds(side1, side2, side3);

        System.out.println("The athlete needs to complete " + Math.ceil(rounds) + " rounds to complete a 5 km run.");

        scanner.close();
    }

    public static double calculateRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;

        double distanceToRun = 5000; // 5 km in meters since other are in meters
        return distanceToRun / perimeter;
    }
}