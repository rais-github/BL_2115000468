import java.util.HashSet;
import java.util.Set;

public class SymmetricDistance {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(3);
        set2.add(4);
        set2.add(5);

        Set<Integer> symmetricDifference = new HashSet<>(set1);
        symmetricDifference.addAll(set2);

        Set<Integer> tmp = new HashSet<>(set1);
        tmp.retainAll(set2);

        symmetricDifference.removeAll(tmp);

        System.out.println(symmetricDifference);
    }
}