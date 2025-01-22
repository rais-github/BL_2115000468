import java.util.Scanner;

public class L2_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the age of Amar:");
        int ageAmar = scanner.nextInt();
        System.out.println("Enter the height of Amar:");
        int heightAmar = scanner.nextInt();

        System.out.println("Enter the age of Akbar:");
        int ageAkbar = scanner.nextInt();
        System.out.println("Enter the height of Akbar:");
        int heightAkbar = scanner.nextInt();

        System.out.println("Enter the age of Anthony:");
        int ageAnthony = scanner.nextInt();
        System.out.println("Enter the height of Anthony:");
        int heightAnthony = scanner.nextInt();

        scanner.close();

        int youngestAge = Math.min(ageAmar, Math.min(ageAkbar, ageAnthony));
        // Ternary operator to find the youngest friend
        String youngestFriend = (youngestAge == ageAmar) ? "Amar" : (youngestAge == ageAkbar) ? "Akbar" : "Anthony";

       
        int tallestHeight = Math.max(heightAmar, Math.max(heightAkbar, heightAnthony));
        // Ternary operator to find the tallest friend
        String tallestFriend = (tallestHeight == heightAmar) ? "Amar" : (tallestHeight == heightAkbar) ? "Akbar" : "Anthony";

        System.out.println("The youngest friend is " + youngestFriend + " with age " + youngestAge);
        System.out.println("The tallest friend is " + tallestFriend + " with height " + tallestHeight);
    }
    
}
