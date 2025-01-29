import java.util.Scanner;

public class reverseString{
    public static void main(String ...args){
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        String reversedString = "";
        for(int i = string.length()-1; i >= 0; i--){
            reversedString += string.charAt(i);
        }
        System.out.println("Reversed String: "+reversedString);
        
        scanner.close();
    }
}