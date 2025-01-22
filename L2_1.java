import java.util.Scanner;

public class L2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a year: ");
        short year = scanner.nextShort();

        if (year >= 1582) {
           if(year % 400 == 0) {
                if(year%4==0)
                {
                    if(year%100!=0)
                    {
                        System.out.println("leap year");
                    }else{
                        System.out.println("Not a leap year");
                    }
                }else{
                    System.out.println("Not a leap year");
                }
           }else{
            System.out.println("Not a leap year");
           }
        } else {
            System.out.println("The LeapYear program only works for year >= 1582.");
        }

      

        scanner.close();
    }
}
