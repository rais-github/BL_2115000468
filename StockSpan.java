import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {

        int[] arr = {100, 80, 60, 70, 60, 75, 85};
        int[] span = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        span[0] = 1;
        st.push(0);
        for(int i = 1; i < arr.length; i++) {
            while(!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            if(st.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - st.peek();
            }
            st.push(i);
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.print(span[i] + " ");
        }
        

    }   
}
