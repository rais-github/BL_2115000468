import java.util.Scanner;
import java.util.Stack;

public class sortStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        System.out.println("Enter the number of elements in the stack: ");
        int n = sc.nextInt();

        System.out.println("Enter the elements of the stack: ");
        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }

        sortStackMethod(stack);

        sc.close();
    }

    private static void sortStackMethod(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            sortStackMethod(stack);
            sortedInsert(stack, temp);
        }
    }

    private static void sortedInsert(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
            return;
        }

        int temp = stack.pop();
        sortedInsert(stack, element);

        stack.push(temp);
    }
}
