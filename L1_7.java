import java.util.Scanner;

public class L1_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number");
        int number = scanner.nextInt();

        int arrSize = number/2 ;

        int [] evenStore = new int[arrSize];
        int [] oddStore = new int[arrSize];

        int eveIdx = 0 , oddIdx = 0;
        for(int i =1 ; i <= number ; i++)
        {
            if((i&1)==1)
            {
                oddStore[oddIdx++]=i;
                
            }
            else{
                evenStore[eveIdx++]=i;
            }
        }
        System.out.println("Even array is mentioned below");
        for(int num : evenStore){
            System.out.print(num+" ");
        }
        System.out.println();
        for(int num:oddStore){
            System.out.print(num+" ");
        }
        scanner.close();
    }
}
