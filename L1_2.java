import java.util.Scanner;
public class L1_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] nums = new int [5];
        for(int i = 0 ; i < nums.length ; i++)
        {
            nums[i]=scanner.nextInt();
        }

        for(int num:nums)
        {
            if(num>0)
            {
                if((num&1)==0){
                    System.out.println(num+" is even positive number");
                }
                else{
                    System.out.println(num+" is odd positive number");
                }
            }
            else if (num<0){
                System.out.println(num+" is negative number");
            }
            else{
                System.out.println("The number is 0");
            }
        }

        if(nums[4]>nums[0])
        {
            System.out.println("First number is smaller then last");
        }else if(nums[0]>nums[4])
        {
            System.out.println("First number in the larger then last ");
        }else{
            System.out.println("Both first and last numbers are equal");
        }
        scanner.close();
    }
}
