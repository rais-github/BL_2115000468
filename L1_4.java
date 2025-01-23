import java.util.Scanner;
public class L1_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int size = 10;
        int [] userInputs = new int[size];
        int i=0;
        while(true && i<11){
            int num = scanner.nextInt();
            if(num<=0){
                break;
            }else{
                userInputs[i++]=num;
            }

        }
        if(i==11) i--;
        int totalSum = 0;
        for(int j = 0 ; j < i ; j++)
        {
            totalSum+=userInputs[j];
            System.out.print(userInputs[j]+" ");
        }
        System.out.println();
        System.out.println("The sum of numbers entered by the user is: "+totalSum);
        scanner.close();
    }
}
