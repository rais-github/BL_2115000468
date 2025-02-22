public class CensorWords {
    public static void main(String[] args) {
        String input = "This is a damn bad example with some stupid words.";
        String[] badWords = {"damn", "stupid"};
        
        for (String badWord : badWords) {
            input = input.replaceAll("(?i)" + badWord, "****");
        }
        
        System.out.println(input);
    }
}
