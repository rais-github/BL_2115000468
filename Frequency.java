import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Frequency {
    public static Map<String, Integer> countFrequency(List<String> list) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String item : list) {
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        
        List<String> list = List.of("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Integer> frequency = countFrequency(list);
        System.out.println(frequency);
    }
}