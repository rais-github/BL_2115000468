import java.util.Scanner;

public class L1_18 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = input.nextInt();
        while(num<5 && num>9){
            System.out.print("Enter a number: ");
            num = input.nextInt();
        }
        for(int i=1 ; i<=10 ; i++)
        {
            System.out.println(num + " x " + i + " = " + num*i+"\n");
        }
        input.close();
    }
    
}
