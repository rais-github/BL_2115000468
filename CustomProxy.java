import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// Define the interface
interface Greeting {
    void sayHello();
}

// Implement the interface
class GreetingImpl implements Greeting {
    @Override
    public void sayHello() {
        System.out.println("Hello, world!");
    }
}

// Create the custom logging proxy handler
class LoggingInvocationHandler implements InvocationHandler {
    private final Object target;

    public LoggingInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Invoking method: " + method.getName());
        return method.invoke(target, args);
    }
}

// Main class to demonstrate the proxy
public class CustomProxy {
    public static void main(String[] args) {
        Greeting greeting = new GreetingImpl();
        Greeting proxyInstance = (Greeting) Proxy.newProxyInstance(
                greeting.getClass().getClassLoader(),
                greeting.getClass().getInterfaces(),
                new LoggingInvocationHandler(greeting)
        );

        proxyInstance.sayHello();
    }
}