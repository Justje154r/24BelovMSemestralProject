import java.util.Scanner;

public class MatrixReduction {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Zadejte rozměr matice: ");
            int n = sc.nextInt();
            if (n <= 0) {
                break;
            }
            int[][] matrix = new int[n][n];
            System.out.println("Zadejte hodnoty matice (řádek po řádku):");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            int[][] reducedMatrix = zmenitMatici(matrix);
            if (reducedMatrix == null) {
                System.out.println("Matice nelze dále upravovat.");
                System.out.println("Původní matice (" + (n) + " x " + (n) + "):");
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[i].length; j++) {
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Upravená matice (" + (n - 1) + " x " + (n - 1) + "):");
                for (int i = 0; i < reducedMatrix.length; i++) {
                    for (int j = 0; j < reducedMatrix[i].length; j++) {
                        System.out.print(reducedMatrix[i][j] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    public static int[][] zmenitMatici(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    boolean isNonZeroElement = true;
                    for (int k = 0; k < matrix.length; k++) {
                        if (k != i && matrix[k][j] != 0) {
                            isNonZeroElement = false;
                            break;
                        }
                    }
                    for (int k = 0; k < matrix[i].length; k++) {
                        if (k != j && matrix[i][k] != 0) {
                            isNonZeroElement = false;
                            break;
                        }
                    }
                    if (isNonZeroElement) {
                        return odstranitRadekACislo(matrix, i, j);
                    }
                }
            }
        }
        return null;
    }

    public static int[][] odstranitRadekACislo (int[][] matrix, int row, int col) {
        int[][] reducedMatrix = new int[matrix.length - 1][matrix[0].length - 1];
        int reducedMatrixRow = 0;
        int reducedMatrixCol = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (i == row) {
                continue;
            }
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == col) {
                    continue;
                }
                reducedMatrix[reducedMatrixRow][reducedMatrixCol++] = matrix[i][j];
            }
            reducedMatrixRow++;
            reducedMatrixCol = 0;
        }
        return reducedMatrix;
    }
}

