public class ReverseString {
    public static void main(String[] args) {
        String input = "hello";
        StringBuilder sb = new StringBuilder();
        
        for (int i = input.length() - 1; i >= 0; i--) {
            sb.append(input.charAt(i));
        }
        
        String reversed = sb.toString();
        System.out.println("Reversed string: " + reversed);
    }
}