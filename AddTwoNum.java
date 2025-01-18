import java.util.Scanner;
public class AddTwoNum{
	public static void main(String ...args){
		Scanner inp = new Scanner(System.in);
		System.out.print("First Number: ");
		int num1 = inp.nextInt();
		System.out.println();
		System.out.print("Second Number: ");
		int num2 = inp.nextInt();
		
		System.out.println();
		int sum = num1+num2;
		System.out.println("The sum of first and second number is: "+sum);
	}
}