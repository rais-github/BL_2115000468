import java.util.*;

public class CompareDS {
    public static void main(String[] args) {
        int[] array = new int[1000000];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

       
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
            hashSet.add(i);
            treeSet.add(i);
        }

        
        int searchElement = 999999;

        // Array search
        long startTime = System.nanoTime();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searchElement) {
                break;
            }
        }
        long endTime = System.nanoTime();
        System.out.println("Array search time: " + (endTime - startTime) + " ns");

        // HashSet search
        startTime = System.nanoTime();
        hashSet.contains(searchElement);
        endTime = System.nanoTime();
        System.out.println("HashSet search time: " + (endTime - startTime) + " ns");

        // TreeSet search
        startTime = System.nanoTime();
        treeSet.contains(searchElement);
        endTime = System.nanoTime();
        System.out.println("TreeSet search time: " + (endTime - startTime) + " ns");
    }
}
