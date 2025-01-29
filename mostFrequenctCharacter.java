import java.util.Scanner;

public class mostFrequenctCharacter{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = scanner.nextLine();
        int[] freq = new int[256];
        for(int i = 0; i < str.length(); i++){
            freq[str.charAt(i)]++;
        }
        int max = -1;
        char result = ' ';
        for(int i = 0; i < str.length(); i++){
            if(max < freq[str.charAt(i)]){
                max = freq[str.charAt(i)];
                result = str.charAt(i);
            }
        }
        System.out.println("Most frequent character is: " + result);
        scanner.close();
    }
}