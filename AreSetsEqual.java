import java.util.HashSet;
import java.util.Set;

public class AreSetsEqual {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        
        set1.add(1);
        set1.add(2);
        set1.add(3);

        
        set2.add(3);
        set2.add(1);
        set2.add(2);

        boolean areEqual = areSetsEqual(set1, set2);
        System.out.println("Are the sets equal? " + areEqual);
    }

    public static boolean areSetsEqual(Set<?> set1, Set<?> set2) {
        if (set1 == null || set2 == null) {
            return false;
        }
        return set1.equals(set2);
    }
}