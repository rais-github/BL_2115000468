import java.util.HashMap;
import java.util.Map;

public class ExtractRepeatingWords {
    public static void main(String[] args) {
        String sentence = "This is is a repeated repeated word test.";
        findRepeatingWords(sentence);
    }

    public static void findRepeatingWords(String sentence) {
        String[] words = sentence.toLowerCase().split("\\W+");
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println("Repeating words:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey());
            }
        }
    }
}