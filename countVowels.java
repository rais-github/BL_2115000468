import java.util.Scanner;

public class countVowels{
    public static void main(String ...args){
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        int vowelCount = 0 , consonantCount = 0;
        for(char ch:string.toCharArray()){
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                vowelCount++;
            }else{
                consonantCount++;
            }   
        }
        System.out.println("Vowels: "+vowelCount);
        System.out.println("Consonants: "+consonantCount);
        
        scanner.close();
    }
}