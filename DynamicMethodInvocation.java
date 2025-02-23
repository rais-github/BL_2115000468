import java.util.Scanner;

class MathOperations {
    public void add(int a, int b) {
        System.out.println("Sum: " + (a + b));
    }

    public void sub(int a, int b) {
        System.out.println("Sub: " + (a - b));
    }

    public void mul(int a, int b) {
        System.out.println("Mul: " + (a * b));
    }

    public void div(int a, int b) {
        System.out.println("Div: " + (a / b));
    }
}

public class DynamicMethodInvocation {
    public static void main(String[] args) {
        MathOperations obj = new MathOperations();
        Class<?> c = obj.getClass();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter method name (add, sub, mul, div):");
        String methodName = scanner.nextLine();

        System.out.println("Enter first parameter:");
        int param1 = scanner.nextInt();

        System.out.println("Enter second parameter:");
        int param2 = scanner.nextInt();

        try {
            c.getDeclaredMethod(methodName, int.class, int.class).invoke(obj, param1, param2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}
