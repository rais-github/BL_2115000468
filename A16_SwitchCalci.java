import java.util.Scanner;
<<<<<<< HEAD
public class A16_SwitchCalci {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter first operand:");
        double a = inp.nextDouble();
        System.out.println("Enter Second operand");
        double b = inp.nextDouble();
        System.out.println("Enter the operation: ");
        char op = inp.next().charAt(0);
        double res = 0d;
=======

public class A16_SwitchCalci {
    public static void main(String ...args) throws ArithmeticException {
        System.out.println("Enter the two numbers: ");
        Scanner inp = new Scanner(System.in);
        double a = inp.nextDouble();
        double b = inp.nextDouble();
        System.out.println("Enter the operation: ");
        char op = inp.next().charAt(0);
        double res = 0;
>>>>>>> 07818fb3d593e28bf36f4b6db763740d1e1cecf1
        try {
            switch(op) {
                case '+': res = a + b; break;
                case '-': res = a - b; break;
                case '*': res = a * b; break;
<<<<<<< HEAD
                case '/':
                    if (b == 0) {
                        throw new ArithmeticException("Division by zero is not allowed");
                    }
                    res = a / b;
                    break;
                default:
=======
                case '/': 
                    if (b == 0) {
                        throw new ArithmeticException("Division by zero is not allowed");
                    }
                    res = a / b; 
                    break;
                default: 
>>>>>>> 07818fb3d593e28bf36f4b6db763740d1e1cecf1
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
<<<<<<< HEAD
}
=======
}
>>>>>>> 07818fb3d593e28bf36f4b6db763740d1e1cecf1
