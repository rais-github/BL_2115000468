import java.util.HashMap;
import java.util.Map;

public class MergeTwoMaps {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("a", 1);
        map1.put("b", 2);
        map1.put("c", 3);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("b", 3);
        map2.put("c", 4);
        map2.put("d", 5);

        Map<String, Integer> mergedMap = new HashMap<>(map1);

        map2.forEach((key, value) -> mergedMap.merge(key, value, Integer::sum));

        System.out.println(mergedMap);
    }
}
