import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

enum Priority { LOW, MEDIUM, HIGH }

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo{
    Priority priority() default Priority.MEDIUM;
    String assignedTo();
}


class TaskManager{
    @TaskInfo(priority = Priority.HIGH, assignedTo = "John")
    public void doTask1(){
        System.out.println("Task 1 is done by John");
    }

    @TaskInfo(priority = Priority.LOW, assignedTo = "Smith")
    public void doTask2(){
        System.out.println("Task 2 is done by Smith");
    }

}

public class Annotation_TaskInfo {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        taskManager.doTask1();
        taskManager.doTask2();    
    }
}
