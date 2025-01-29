import java.util.Scanner;

public class compareString{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first string: ");
        String str1 = sc.nextLine();
        System.out.println("Enter the second string: ");
        String str2 = sc.nextLine();
        int len1 = str1.length();
        int len2 = str2.length();
        
        int minLen = Math.min(len1, len2);

        for(int i = 0; i < minLen; i++){
            if(str1.charAt(i) < str2.charAt(i)){
                System.out.println("String 1 is lexicographically smaller than String 2");
                break;
            }else{
                System.out.println("String 2 is lexicographically smaller than String 1");
                break;
            }
        }
        sc.close();
    }
}