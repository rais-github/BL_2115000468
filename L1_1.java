import java.util.Scanner;
public class L1_1{
	public static void main(String ...args){
	Scanner inp = new Scanner(System.in);
	int number = inp.nextInt();
	if(number%5==0){
		System.out.println(number+" is divisible by 5");
}
else{
	System.out.println(number+" is not divisble by 5");
}
inp.close();
}
}
