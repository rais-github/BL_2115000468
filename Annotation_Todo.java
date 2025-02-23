import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

enum Priority {LOW, MEDIUM, HIGH}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    Priority priority() default Priority.MEDIUM;
}

public class Annotation_Todo {

    @Todo(task = "Implement login feature", assignedTo = "Alice", priority = Priority.HIGH)
    public void login() {
        // login code
    }

    @Todo(task = "Implement logout feature", assignedTo = "Bob")
    public void logout() {
        // logout code
    }

    @Todo(task = "Implement registration feature", assignedTo = "Charlie", priority = Priority.LOW)
    public void register() {
        // registration code
    }

    public static void main(String[] args) {
        Method[] methods = Annotation_Todo.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Task: " + todo.task());
                System.out.println("Assigned To: " + todo.assignedTo());
                System.out.println("Priority: " + todo.priority());
                System.out.println();
            }
        }
    }
}
