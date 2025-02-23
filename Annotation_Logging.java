import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
    String log() default "Execution Time";
}



public class Annotation_Logging {

    @LogExecutionTime(log = "Method 1")
    private static void method1() {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum += i;
        }
    }

    @LogExecutionTime(log = "Method 2")
    private static void method2() {
        int total = (int) Math.pow(2, 10);
        for (int i = 0; i < total; i++) {
            total -= i;
        }
    }

    public static void main(String[] args) throws Exception {
        executeWithLogging("method1");
        executeWithLogging("method2");
    }

    private static void executeWithLogging(String methodName) throws Exception {
        Method method = Annotation_Logging.class.getDeclaredMethod(methodName);
        if (method.isAnnotationPresent(LogExecutionTime.class)) {
            LogExecutionTime logExecutionTime = method.getAnnotation(LogExecutionTime.class);
            System.out.println("Executing " + logExecutionTime.log());
            long startTime = System.nanoTime();
            method.setAccessible(true);
            method.invoke(null);
            long endTime = System.nanoTime();
            System.out.println(logExecutionTime.log() + " took " + (endTime - startTime) + " nanoseconds");
        }
    }
}
