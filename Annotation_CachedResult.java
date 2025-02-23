import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.HashMap;

class Pair<K, V> {
    K key;
    V value;
    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return key.equals(pair.key) && value.equals(pair.value);
    }

    @Override
    public int hashCode() {
        return key.hashCode() * 31 + value.hashCode();
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CachedResult {}

class Cacher {
    private HashMap<Pair<String, Integer>, Integer> cache = new HashMap<>();

    public Integer cachedResult(String methodName, Integer arg) {
        Pair<String, Integer> pair = new Pair<>(methodName, arg);
        return cache.get(pair);
    }

    public void putResult(String methodName, Integer arg, Integer result) {
        Pair<String, Integer> pair = new Pair<>(methodName, arg);
        cache.put(pair, result);
    }
}

public class Annotation_CachedResult {
    private static Cacher cacher = new Cacher();

    @CachedResult
    private static int fib(int n) {
        Integer cachedResult = cacher.cachedResult("fib", n);
        if (cachedResult != null) {
            return cachedResult;
        }
        int result;
        if (n <= 1) {
            result = n;
        } else {
            result = fib(n - 1) + fib(n - 2);
        }
        cacher.putResult("fib", n, result);
        return result;
    }

    @CachedResult
    private static int sumToN(int n) {
        Integer cachedResult = cacher.cachedResult("sumToN", n);
        if (cachedResult != null) {
            return cachedResult;
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        cacher.putResult("sumToN", n, sum);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(fib(10)); // Should compute and cache the result
        System.out.println(fib(10)); // Should return the cached result
        System.out.println(sumToN(10)); // Should compute and cache the result
        System.out.println(sumToN(10)); // Should return the cached result
    }
}
