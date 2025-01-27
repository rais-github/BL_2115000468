import java.util.Random;

public class L3_13 {

    public static void main(String[] args) {
        
        int[][] matrix1 = createRandomMatrix(3, 3);
        int[][] matrix2 = createRandomMatrix(3, 3);

        displayMatrix(matrix1);
        displayMatrix(matrix2);

        int[][] sum = addMatrices(matrix1, matrix2);
        displayMatrix(sum);

        int[][] difference = subtractMatrices(matrix1, matrix2);
        displayMatrix(difference);

        int[][] product = multiplyMatrices(matrix1, matrix2);
        displayMatrix(product);

        int[][] transpose = transposeMatrix(matrix1);
        displayMatrix(transpose);

        int determinant2x2 = determinant2x2(new int[][]{{1, 2}, {3, 4}});
        System.out.println("Determinant of 2x2 matrix: " + determinant2x2);

        int determinant3x3 = determinant3x3(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println("Determinant of 3x3 matrix: " + determinant3x3);

        int[][] inverse2x2 = inverse2x2(new int[][]{{1, 2}, {3, 4}});
        displayMatrix(inverse2x2);

        int[][] inverse3x3 = inverse3x3(new int[][]{{1, 2, 3}, {0, 1, 4}, {5, 6, 0}});
        displayMatrix(inverse3x3);
    }

    public static int[][] createRandomMatrix(int rows, int cols) {
        Random rand = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(10); 
            }
        }
        return matrix;
    }

    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    public static int[][] subtractMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;
        int[][] result = new int[rows1][cols2];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transpose = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }

    public static int determinant2x2(int[][] matrix) {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    public static int determinant3x3(int[][] matrix) {
        int determinant = 0;
        for (int i = 0; i < 3; i++) {
            determinant += matrix[0][i] * (matrix[1][(i + 1) % 3] * matrix[2][(i + 2) % 3] - matrix[1][(i + 2) % 3] * matrix[2][(i + 1) % 3]);
        }
        return determinant;
    }

    public static int[][] inverse2x2(int[][] matrix) {
        int determinant = determinant2x2(matrix);
        if (determinant == 0) {
            throw new IllegalArgumentException("Matrix is not invertible");
        }
        int[][] inverse = {
            {matrix[1][1], -matrix[0][1]},
            {-matrix[1][0], matrix[0][0]}
        };
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                inverse[i][j] /= determinant;
            }
        }
        return inverse;
    }

    public static int[][] inverse3x3(int[][] matrix) {
        int determinant = determinant3x3(matrix);
        if (determinant == 0) {
            throw new IllegalArgumentException("Matrix is not invertible");
        }
        int[][] adjoint = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                adjoint[i][j] = ((matrix[(j + 1) % 3][(i + 1) % 3] * matrix[(j + 2) % 3][(i + 2) % 3]) - (matrix[(j + 1) % 3][(i + 2) % 3] * matrix[(j + 2) % 3][(i + 1) % 3]));
            }
        }
        int[][] inverse = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                inverse[i][j] = adjoint[i][j] / determinant;
            }
        }
        return inverse;
    }

    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}