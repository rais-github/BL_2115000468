import java.util.Scanner;

public class L2_5 {

    public static double convertYardsToFeet(double yards) {
        double yards2feet = 3;
        return yards * yards2feet;
    }

    public static double convertFeetToYards(double feet) {
        double feet2yards = 0.333333;
        return feet * feet2yards;
    }

    public static double convertMetersToInches(double meters) {
        double meters2inches = 39.3701;
        return meters * meters2inches;
    }

    public static double convertInchesToMeters(double inches) {
        double inches2meters = 0.0254;
        return inches * inches2meters;
    }

    public static double convertInchesToCentimeters(double inches) {
        double inches2cm = 2.54;
        return inches * inches2cm;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter value to convert:");
        double value = scanner.nextDouble();

        System.out.println("Choose conversion type:");
        System.out.println("1. Yards to Feet");
        System.out.println("2. Feet to Yards");
        System.out.println("3. Meters to Inches");
        System.out.println("4. Inches to Meters");
        System.out.println("5. Inches to Centimeters");

        int choice = scanner.nextInt();
        double result = 0;

        switch (choice) {
            case 1:
                result = convertYardsToFeet(value);
                break;
            case 2:
                result = convertFeetToYards(value);
                break;
            case 3:
                result = convertMetersToInches(value);
                break;
            case 4:
                result = convertInchesToMeters(value);
                break;
            case 5:
                result = convertInchesToCentimeters(value);
                break;
            default:
                System.out.println("Invalid choice");
                scanner.close();
                return;
        }

        System.out.println("Converted value: " + result);

        scanner.close();
    }
}