public class ExtractCapitalWordsFromSentence {
    public static void main(String[] args) {
        String sentence = "This is a Sample Sentence with Capital Words";
        String[] words = sentence.split(" ");
        for (String word : words) {
            if (word.matches("[A-Z][a-z]*")) {
                System.out.println(word);
            }
        }

        
    }
}