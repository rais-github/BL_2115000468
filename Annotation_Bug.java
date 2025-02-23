import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Repeatable;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@interface BugReports {
    BugReport[] value();
}

public class Annotation_Bug {

    @BugReports({
        @BugReport(description = "Null pointer exception when input is null"),
        @BugReport(description = "Array index out of bounds exception")
    })
    public void buggyMethod() {
        // Method implementation
    }

    public static void main(String[] args) {
        try {
            Method method = Annotation_Bug.class.getMethod("buggyMethod");
            if (method.isAnnotationPresent(BugReports.class)) {
                BugReports bugReports = method.getAnnotation(BugReports.class);
                for (BugReport bugReport : bugReports.value()) {
                    System.out.println("Bug Report: " + bugReport.description());
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}