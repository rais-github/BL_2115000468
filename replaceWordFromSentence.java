import java.util.Scanner;

public class replaceWordFromSentence{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the sentence: ");
        String sentence = scanner.nextLine();
        System.out.println("Enter the word to be replaced: ");
        String wordToBeReplaced = scanner.nextLine();
        System.out.println("Enter the word to be replaced with: ");
        String wordToBeReplacedWith = scanner.nextLine();
        for (String word : sentence.split(" ")) {
            if (word.equals(wordToBeReplaced)) {
                sentence = sentence.replace(wordToBeReplaced, wordToBeReplacedWith);
                break;
            }
        }
        System.out.println("Updated sentence: " + sentence);
        scanner.close();
    }   
}
