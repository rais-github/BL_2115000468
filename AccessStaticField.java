import java.lang.reflect.Field;

class Configuration {
    @SuppressWarnings("unused")
    private static String API_KEY = "aqwertyuiop1234@";
}

public class AccessStaticField {
    public static void main(String[] args) {
        try {
            Class<?> configClass = Configuration.class;
            Field field = configClass.getDeclaredField("API_KEY");
            field.setAccessible(true);
            System.out.println("Original value: " + field.get(null));
            field.set(null, "new_api_key");
            System.out.println("New value: " + field.get(null));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
