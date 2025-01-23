import java.util.Scanner;

public class L1_1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int students = 10;
        int [] studentAge = new int [students];
        for(int i = 0 ; i < students ; i++)
        {
            studentAge[i] = scanner.nextInt();
        }

        for(int age:studentAge)
        {
            if(age<0)
            {
                System.out.println("Invalid Age!");
            }
            else if(age >= 18)
            {
                System.out.println("Student with "+age+" is eligible to vote");
            }
            else{
                System.out.println("Student with "+age+" is not eligible to vote");
            }
        }
        scanner.close();
    }
}