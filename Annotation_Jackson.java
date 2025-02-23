import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name() default "";
}

class User {
    @JsonField(name = "user_name")
    private final String name;
    
    @JsonField(name = "user_age")
    private final int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class Annotation_Jackson {
    public static void main(String[] args) {
        User user = new User("John Doe", 30);
        String jsonString = convertToJson(user);
        System.out.println(jsonString);
    }

    public static String convertToJson(Object obj) {
        Class<?> objClass = obj.getClass();
        Map<String, String> jsonElements = new HashMap<>();

        for (Field field : objClass.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField annotation = field.getAnnotation(JsonField.class);
                String key = annotation.name().isEmpty() ? field.getName() : annotation.name();
                try {
                    String value = field.get(obj).toString();
                    jsonElements.put(key, value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        StringBuilder jsonString = new StringBuilder();
        jsonString.append("{");
        for (Map.Entry<String, String> entry : jsonElements.entrySet()) {
            jsonString.append("\"").append(entry.getKey()).append("\": \"").append(entry.getValue()).append("\", ");
        }
        if (jsonString.length() > 1) {
            jsonString.setLength(jsonString.length() - 2); // Remove the trailing comma and space
        }
        jsonString.append("}");

        return jsonString.toString();
    }
}
