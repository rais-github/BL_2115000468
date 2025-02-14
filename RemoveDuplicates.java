public class RemoveDuplicates {
    public static void main(String[] args) {
        String input = "programming";
        String result = removeDuplicates(input);
        System.out.println("Original String: " + input);
        System.out.println("String after removing duplicates: " + result);
    }

    public static String removeDuplicates(String str) {
        StringBuilder sb = new StringBuilder();
        boolean[] seen = new boolean[256]; 
        for (char c : str.toCharArray()) {
            if (!seen[c]) {
                sb.append(c);
                seen[c] = true;
            }
        }

        return sb.toString();
    }
}