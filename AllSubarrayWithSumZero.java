import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AllSubarrayWithSumZero {
    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 4, -2, -2, 1, 5, -3};
        List<int[]> result = findAllSubarraysWithSumZero(arr);
        for (int[] subarray : result) {
            System.out.print("[");
            for (int i = subarray[0]; i <= subarray[1]; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println("]");
        }
    }

    public static List<int[]> findAllSubarraysWithSumZero(int[] arr) {
        List<int[]> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> sumMap = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == 0) {
                result.add(new int[]{0, i});
            }

            if (sumMap.containsKey(sum)) {
                List<Integer> indices = sumMap.get(sum);
                for (int index : indices) {
                    result.add(new int[]{index + 1, i});
                }
            }

            sumMap.putIfAbsent(sum, new ArrayList<>());
            sumMap.get(sum).add(i);
        }

        return result;
    }
}