import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class KeyWithHighestValue {
    public static String getKeyWithHighestValue(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 10);
        map.put("b", 30);
        map.put("c", 20);

        String key = getKeyWithHighestValue(map);
        System.out.println("Key with highest value: " + key);
    }
}
