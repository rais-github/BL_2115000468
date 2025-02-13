public class ExamScore {

    public static void selectionSort(int[] scores) {
        int n = scores.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] scores = {88, 94, 72, 85, 91, 67, 78, 99, 83, 76};

        System.out.println("Original scores:");
        for (int score : scores) {
            System.out.print(score + " ");
        }
        System.out.println();

        selectionSort(scores);

        System.out.println("Sorted scores:");
        for (int score : scores) {
            System.out.print(score + " ");
        }
    }
}