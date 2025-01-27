import java.util.Scanner;
import static java.lang.Math.*;
public class L1_12 {
    public double[] calculateTrigonometricFunctions(double angle) {
        double radians = toRadians(angle);
        double sine = sin(radians);
        double cosine = cos(radians);
        double tangent = tan(radians);

        return new double[]{sine, cosine, tangent};
    }

    public static void main(String[] args) {
        L1_12 trigCalculator = new L1_12();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the angle in degrees: ");
        double angle = scanner.nextDouble();
        scanner.close();
        double[] results = trigCalculator.calculateTrigonometricFunctions(angle);

        System.out.println("Sine: " + results[0]);
        System.out.println("Cosine: " + results[1]);
        System.out.println("Tangent: " + results[2]);
    }
}