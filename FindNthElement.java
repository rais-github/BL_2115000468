import java.util.LinkedList;

public class FindNthElement {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        int N = 2;
        String result = findNthFromEnd(list, N);
        System.out.println("The " + N + "th element from the end is: " + result);
    }

    public static String findNthFromEnd(LinkedList<String> list, int N) {
        if (list == null || N <= 0) {
            return null;
        }

        int size = list.size();
        if (N > size) {
            return null;
        }

        int indexFromStart = size - N;
        return list.get(indexFromStart);
    }
}