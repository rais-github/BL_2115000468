import java.util.Scanner;

public class A16_SwitchCalci {
    public static void main(String ...args) throws ArithmeticException {
        System.out.println("Enter the two numbers: ");
        Scanner inp = new Scanner(System.in);
        double a = inp.nextDouble();
        double b = inp.nextDouble();
        System.out.println("Enter the operation: ");
        char op = inp.next().charAt(0);
        double res = 0;
        try {
            switch(op) {
                case '+': res = a + b; break;
                case '-': res = a - b; break;
                case '*': res = a * b; break;
                case '/': 
                    if (b == 0) {
                        throw new ArithmeticException("Division by zero is not allowed");
                    }
                    res = a / b; 
                    break;
                default: 
                    System.out.println("Invalid operation");
                    return;
            }
            System.out.println("Result: " + res);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            inp.close();
        }
    }
}