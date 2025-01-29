import java.util.Scanner;

public class palindrome{
    public static void main(String ...args){
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        
        int i = 0;
        int j = string.length() - 1;
        boolean isPalindrome = true;
        while(i < j){
            if(string.charAt(i) != string.charAt(j)){
                isPalindrome = false;
                break;
            }
            i++;
            j--;
        }
        if(isPalindrome){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
        
        scanner.close();
    }
}