import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetToList {
    public static void main(String[] args) {
       
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(5);
        hashSet.add(3);
        hashSet.add(8);
        hashSet.add(1);

        
        List<Integer> list = new ArrayList<>(hashSet);

       
        Collections.sort(list);

       
        System.out.println("Sorted List: " + list);
    }
}