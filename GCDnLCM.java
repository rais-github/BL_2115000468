import java.util.Scanner;
public class GCDnLCM{
    public static int getInput(String prompt, Scanner sc){
        System.out.print(prompt);
        return sc.nextInt();
    }
    public static void main(String[] args) {
        int a = getInput("Enter first number: ",new Scanner(System.in));
        int b = getInput("Enter second number: ",new Scanner(System.in));

        int choice = getInput("Enter 1 for GCD and 2 for LCM: ",new Scanner(System.in));

        while(choice==1 || choice==2){
            if(choice==1){
                System.out.println("GCD of "+a+" and "+b+" is "+gcd(a,b));
            }else{
                System.out.println("LCM of "+a+" and "+b+" is "+lcm(a,b));
            }
            choice = getInput("Enter 1 for GCD and 2 for LCM: ",new Scanner(System.in));

        }

    }
    private static int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    };
    private static int lcm(int a, int b){
        return a*b/gcd(a,b);
    };
}