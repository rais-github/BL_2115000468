import java.lang.reflect.Field;
import java.util.Map;

public class CustomObjectMapper {

    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        T instance;
        try {
            instance = clazz.getDeclaredConstructor().newInstance();
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                Field field = clazz.getDeclaredField(entry.getKey());
                field.setAccessible(true);
                field.set(instance, entry.getValue());
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to map properties to object", e);
        }
        return instance;
    }
    public static void main(String[] args) {
        Map<String, Object> properties = Map.of("name", "John", "age", 30);
        Person person = toObject(Person.class, properties);
        System.out.println(person);
        
    }
}