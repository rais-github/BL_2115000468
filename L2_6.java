import java.util.Scanner;

public class L2_6 {

    public static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double convertPoundsToKilograms(double pounds) {
        return pounds * 0.453592;
    }

    public static double convertKilogramsToPounds(double kilograms) {
        return kilograms * 2.20462;
    }

    public static double convertGallonsToLiters(double gallons) {
        return gallons * 3.78541;
    }

    public static double convertLitersToGallons(double liters) {
        return liters * 0.264172;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] results = new double[6];

        System.out.print("Enter Fahrenheit: ");
        double fahrenheit = scanner.nextDouble();
        results[0] = convertFahrenheitToCelsius(fahrenheit);

        System.out.print("Enter Celsius: ");
        double celsius = scanner.nextDouble();
        results[1] = convertCelsiusToFahrenheit(celsius);

        System.out.print("Enter Pounds: ");
        double pounds = scanner.nextDouble();
        results[2] = convertPoundsToKilograms(pounds);

        System.out.print("Enter Kilograms: ");
        double kilograms = scanner.nextDouble();
        results[3] = convertKilogramsToPounds(kilograms);

        System.out.print("Enter Gallons: ");
        double gallons = scanner.nextDouble();
        results[4] = convertGallonsToLiters(gallons);

        System.out.print("Enter Liters: ");
        double liters = scanner.nextDouble();
        results[5] = convertLitersToGallons(liters);

        System.out.println("Results:");
        System.out.println("Fahrenheit to Celsius: " + results[0]);
        System.out.println("Celsius to Fahrenheit: " + results[1]);
        System.out.println("Pounds to Kilograms: " + results[2]);
        System.out.println("Kilograms to Pounds: " + results[3]);
        System.out.println("Gallons to Liters: " + results[4]);
        System.out.println("Liters to Gallons: " + results[5]);

        scanner.close();
    }
}