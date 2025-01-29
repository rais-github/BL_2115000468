import java.util.Scanner;

public class countSubstring{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the super string");
        String superString = scanner.nextLine();
        System.out.println("Enter the substring");
        String subString = scanner.nextLine();
        int count = 0;
        String [] words = superString.split(" ");
        for (String word : words) {
            if (word.equals(subString)) {
                count++;
            }
        }
        System.out.println("The substring " + subString + " appears " + count + " times in the super string");
        scanner.close();
    }
}