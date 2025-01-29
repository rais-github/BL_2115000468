import java.util.Scanner;
public class anagrams{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first string: ");
        String str1 = scanner.nextLine();
        System.out.println("Enter the second string: ");
        String str2 = scanner.nextLine();
        if(str1.length() != str2.length()){
            System.out.println("The strings are not anagrams");
            scanner.close();
            return;
        }
        int[] count = new int[256];
        for(int i = 0; i < str1.length(); i++){
            count[str1.charAt(i)]++;
            count[str2.charAt(i)]--;
        }
        for(int i = 0; i < 256; i++){
            if(count[i] != 0){
                System.out.println("The strings are not anagrams");
                scanner.close();
                return;
            }
        }
        System.out.println("The strings are anagrams");

        scanner.close();
    }
}