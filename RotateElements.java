import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RotateElements {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        int positions = 2; 

        System.out.println("Original list: " + list);
        rotateList(list, positions);
        System.out.println("Rotated list: " + list);
    }

    public static void rotateList(List<Integer> list, int positions) {
        int size = list.size();
        if (size == 0 || positions % size == 0) {
            return;
        }

        positions = positions % size;
        Collections.rotate(list, positions);
    }
}