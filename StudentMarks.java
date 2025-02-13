import java.util.Scanner;
public class StudentMarks{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of students:");

        int students = scanner.nextInt();

        System.out.println("Enter the elements of the array:");

        int [] marks = new int[students];

        for(int i = 0 ; i < students ; i++){
            marks[i]=scanner.nextInt();
        }

        sortMarks(marks,students);

        scanner.close();
    }
    
    private static void sortMarks(int []marks,int students){

        for (int i = 0; i < students - 1; i++) {
            for (int j = 0; j < students - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                }
            }
        }
        System.out.println("Sorted marks:");
        for (int mark : marks) {
            System.out.println(mark);
        }

    }
}