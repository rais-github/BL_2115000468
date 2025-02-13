public class StudentsAge {

    public static void countingSort(int[] ages) {
        int maxAge = 18;
        int minAge = 10;
        int range = maxAge - minAge + 1;

        int[] count = new int[range];
        int[] output = new int[ages.length];

        
        for (int age : ages) {
            count[age - minAge]++;
        }

        
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        
        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - minAge] - 1] = ages[i];
            count[ages[i] - minAge]--;
        }

        
        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    public static void main(String[] args) {
        int[] ages = {12, 15, 10, 18, 14, 13, 11, 17, 16, 12, 14, 13};
        countingSort(ages);
        for (int age : ages) {
            System.out.print(age + " ");
        }
    }
}