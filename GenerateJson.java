import java.lang.reflect.Field;

public class GenerateJson {

    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder();
        json.append("{");

        Field[] fields = obj.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            try {
                json.append("\"").append(fields[i].getName()).append("\":");
                Object value = fields[i].get(obj);
                if (value instanceof String) {
                    json.append("\"").append(value).append("\"");
                } else {
                    json.append(value);
                }
                if (i < fields.length - 1) {
                    json.append(",");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) {
        // Example usage
        Person person = new Person("John", 30);
        String json = toJson(person);
        System.out.println(json);
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
