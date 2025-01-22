import java.util.Scanner;

public class L1_15 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Looking for factorial of: ");
        int number = inp.nextInt();

        int factorial = 1;
        for(int i = 1; i <= number; i++)
        {
            factorial *= i;
        }
        System.out.println("Factorial: " + factorial);
        inp.close();
    }
}
