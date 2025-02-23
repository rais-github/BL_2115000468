import java.lang.reflect.Field;
class Person {
    @SuppressWarnings("unused")
    private byte age = 12;
}

public class AccessPrivateField {
    public static void main(String[] args) {
        Person person = new Person();
        Class<?> personClass = person.getClass();

        try {
            Field field = personClass.getDeclaredField("age");
            field.setAccessible(true);
            System.out.println("Original value: " + field.get(person));
            field.set(person, (byte) 20);
            System.out.println("New value: " + field.get(person));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }    
}
