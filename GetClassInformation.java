import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class GetClassInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the class name: ");
        String className = scanner.nextLine();
        
        try {
            Class<?> clazz = Class.forName(className);
            displayClassInformation(clazz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void displayClassInformation(Class<?> clazz) {
        System.out.println("Class Name: " + clazz.getName());

        System.out.println("\nFields:");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("Field Name: " + field.getName());
        }

        System.out.println("\nMethods:");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Method Name: " + method.getName());
        }

        System.out.println("\nConstructors:");
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("Constructor: " + constructor);
        }
    }
}
