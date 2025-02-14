public class SearchWord {
    public static void main(String[] args) {
        String[] sentences = {
            "The quick brown fox jumps over the lazy dog",
            "Java is a high-level programming language",
            "Linear search is a simple search algorithm",
            "This is a sample sentence"
        };
        String word = "search";
        String result = findSentenceContainingWord(sentences, word);
        System.out.println(result);
    }

    public static String findSentenceContainingWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }
}