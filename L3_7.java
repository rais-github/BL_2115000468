import java.util.Scanner;
public class L3_7{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] otpArray = new int[10];
        for (int i = 0; i < 10; i++) {
            otpArray[i] = generateOTP();
        }

        if (areOTPsUnique(otpArray)) {
            System.out.println("All OTPs are unique.");
        } else {
            System.out.println("There are duplicate OTPs.");
        }
        }

        public static int generateOTP() {
        return (int)(Math.random() * 900000) + 100000;
        }

        public static boolean areOTPsUnique(int[] otpArray) {
        for (int i = 0; i < otpArray.length; i++) {
            for (int j = i + 1; j < otpArray.length; j++) {
            if (otpArray[i] == otpArray[j]) {
                return false;
            }
            }
        }
        return true;
        
    }
}