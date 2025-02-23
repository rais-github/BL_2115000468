import java.lang.reflect.Method;

public class MethodExecutionTime {

    public static void main(String[] args) {
        try {
            
            Class<?> clazz = YourClass.class;
            Object instance = clazz.getDeclaredConstructor().newInstance();

            for (Method method : clazz.getDeclaredMethods()) {
                if (method.getParameterCount() == 0) { 
                    long startTime = System.nanoTime();
                    method.setAccessible(true);
                    method.invoke(instance);
                    long endTime = System.nanoTime();
                    long duration = endTime - startTime;
                    System.out.println("Execution time of " + method.getName() + ": " + duration + " nanoseconds");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class YourClass {
    // Example methods to measure
    public void method1() {
        // Some code
    }

    public void method2() {
        // Some code
    }
}