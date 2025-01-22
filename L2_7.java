import java.util.Scanner;

public class L2_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter weight in kg: ");
        double weight = scanner.nextDouble();

        System.out.print("Enter height in cm: ");
        double heightCm = scanner.nextDouble();
        double heightM = heightCm / 100;

        double bmi = weight / (heightM * heightM);

        System.out.println("Your BMI is: " + bmi);

        if (bmi < 18.5) {
            System.out.println("You are underweight.");
        } else if (bmi >= 18.5 && bmi < 24.9) {
            System.out.println("You have a normal weight.");
        } else if (bmi >= 25 && bmi < 39.9) {
            System.out.println("You are overweight.");
        } else {
            System.out.println("You are obese.");
        }

        scanner.close();
    }
    
}
