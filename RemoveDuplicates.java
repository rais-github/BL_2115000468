import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> listWithDuplicates = new ArrayList<>();
        listWithDuplicates.add(1);
        listWithDuplicates.add(2);
        listWithDuplicates.add(2);
        listWithDuplicates.add(3);
        listWithDuplicates.add(4);
        listWithDuplicates.add(4);
        listWithDuplicates.add(5);

        List<Integer> listWithoutDuplicates = removeDuplicates(listWithDuplicates);
        System.out.println("List without duplicates: " + listWithoutDuplicates);
    }

    public static <T> List<T> removeDuplicates(List<T> list) {
        return new ArrayList<>(new LinkedHashSet<>(list));
    }
}