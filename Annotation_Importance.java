import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

enum Level {
    LOW, MEDIUM, HIGH
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    Level value() default Level.HIGH;
}

class MyClass {
    @ImportantMethod(Level.LOW)
    public void myLowMethod() {
        System.out.println("This is a low importance method");
    }

    @ImportantMethod(Level.MEDIUM)
    public void myMediumMethod() {
        System.out.println("This is a medium importance method");
    }

    @ImportantMethod(Level.HIGH)
    public void myHighMethod() {
        System.out.println("This is a high importance method");
    }
}

public class Annotation_Importance {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        Class<?> cls = obj.getClass();

        for (Method method : cls.getDeclaredMethods()) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + ", Importance: " + annotation.value());
                try {
                    method.setAccessible(true);
                    method.invoke(obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
