import java.lang.reflect.Method;
class Calculator {
    @SuppressWarnings("unused")
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class InvokePrivateMethod {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Class<?> clazz = calculator.getClass();
        try {
            Method method = clazz.getDeclaredMethod("multiply", int.class, int.class);
            method.setAccessible(true);
            int result = (int) method.invoke(calculator, 2, 3);
            System.out.println(result);
        } catch (Exception e) {
         
        }
    }
}
