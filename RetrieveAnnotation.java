import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Author{
    String name() default "Author name";
}

class Test{
    @Author(name = "John")
    public void display(){
        System.out.println("Test class display method");
    }
}
public class RetrieveAnnotation {
    public static void main(String[] args) {
        Test t = new Test();
        t.display();
        try {
            Author a = t.getClass().getDeclaredMethod("display").getAnnotation(Author.class);
            System.out.println("Author name: "+a.name());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
