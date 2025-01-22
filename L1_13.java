import java.util.Scanner;

public class L1_13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a natural number greater than 0.");
        } else {
            //  using formula
            int sumFormula = n * (n + 1) / 2;

            //  using for loop
            int sumLoop = 0;
            int i = 1;
            for(int j = 0; j < n; j++) {
                sumLoop += i;
                i++;
            }

            // Compare the results
            if (sumFormula == sumLoop) {
                System.out.println("Both computations are correct. Sum: " + sumFormula);
            } else {
                System.out.println("There is an error in the computations.");
            }
        }

        scanner.close();
    }
}
