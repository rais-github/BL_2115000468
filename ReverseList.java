import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReverseList {

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        
        System.out.println("Original ArrayList: " + arrayList);
        reverseList(arrayList);
        System.out.println("Reversed ArrayList: " + arrayList);

        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        
        System.out.println("Original LinkedList: " + linkedList);
        reverseList(linkedList);
        System.out.println("Reversed LinkedList: " + linkedList);
    }

    public static <T> void reverseList(List<T> list) {
        int size = list.size();
        for (int i = 0; i < size / 2; i++) {
            T temp = list.get(i);
            list.set(i, list.get(size - 1 - i));
            list.set(size - 1 - i, temp);
        }
    }
}