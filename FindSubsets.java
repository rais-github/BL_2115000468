import java.util.HashSet;
import java.util.Set;

public class FindSubsets {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);

        
        set2.add(2);
        set2.add(3);

        
        if (set1.containsAll(set2)) {
            System.out.println("set2 is a subset of set1");
        } else {
            System.out.println("set2 is not a subset of set1");
        }
    }
}