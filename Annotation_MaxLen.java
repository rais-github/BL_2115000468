import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
    String message() default "Field exceeds maximum length";
}

class User {
    @MaxLength(value = 10, message = "Username should be less than 10 characters")
    private String username;

    public User(String username) {
        this.username = username;
        validateMaxLength();
    }

    private void validateMaxLength() {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength maxLength = field.getAnnotation(MaxLength.class);
                field.setAccessible(true);
                try {
                    String value = (String) field.get(this);
                    if (value != null && value.length() > maxLength.value()) {
                        throw new IllegalArgumentException(maxLength.message());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class Annotation_MaxLen {
    public static void main(String[] args) {
        try {
            User user = new User("ThisUsernameIsTooLong");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
