import java.util.Scanner;

public class L1_14 {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Looking for factorial of: ");
        int number = inp.nextInt();

        int factorial = 1;
        while(number >= 1)
        {
            factorial *= number;
            number--;
        }
        System.out.println("Factorial: " + factorial);
        inp.close();
    }
}
