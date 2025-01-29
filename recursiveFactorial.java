import java.util.Scanner;

public class recursiveFactorial{
    private static int getInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = getInput(scanner,"Enter a number to calculate its factorial: ");
        int factorial = calculateFactorial(num);
        System.out.println("The factorial of " + num + " is " + factorial);
        scanner.close();
    }
    private static int calculateFactorial(int num) {
        if (num == 0) {
            return 1;
        }
        return num * calculateFactorial(num - 1);
    }
}