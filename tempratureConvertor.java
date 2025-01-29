import java.util.Scanner;

public class tempratureConvertor {

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static void main(String[] args) {

        double fahrenheit =getInput("Enter a temperature in Fahrenheit: ",new Scanner(System.in));
        double celsius = getInput("Enter a temperature in Celsius: ",new Scanner(System.in));

        System.out.println(fahrenheit + " Fahrenheit is equal to " + fahrenheitToCelsius(fahrenheit) + " Celsius");
        System.out.println(celsius + " Celsius is equal to " + celsiusToFahrenheit(celsius) + " Fahrenheit");
    }

    public static double getInput(String prompt, Scanner scanner) {
        System.out.print(prompt);
        return scanner.nextDouble();
    }
}