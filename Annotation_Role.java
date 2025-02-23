import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;


enum Role {
    ADMIN, USER
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    Role value() default Role.ADMIN;
}

class RoleAccess{
    @RoleAllowed(value=Role.ADMIN)
    public void adminRole() {
        System.out.println("This is an admin role method");
    }

    @RoleAllowed(value=Role.USER)
    public void userRole() {
        System.out.println("This is a user role method");
    }
}


public class Annotation_Role {
    public static void main(String[] args) {
        RoleAccess accessObj = new RoleAccess();
        Class<?> cls = accessObj.getClass();

        for(Method method:cls.getDeclaredMethods()){
            if(method.isAnnotationPresent(RoleAllowed.class)){
                RoleAllowed annotation = method.getAnnotation(RoleAllowed.class);
                System.out.println("Method: " + method.getName() + ", Role: " + annotation.value());
                try {
                    if(annotation.value() == Role.ADMIN){
                        
                        method.setAccessible(true);
                        method.invoke(accessObj);
                    } else {
                        System.out.println("User is denied access");
                    }
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
