import java.util.Scanner;

class RowSumThread extends Thread {
    private int[] row;

    public RowSumThread(int[] row) {
        this.row = row;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int value : row) {
            sum += value;
        }
        System.out.println("Sum of row " + Thread.currentThread().getName() + ": " + sum);
    }
}

public class Lab93 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows (m): ");
        int m = scanner.nextInt();
        System.out.print("Enter the number of columns (n): ");
        int n = scanner.nextInt();

        int[][] matrix = new int[m][n];
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Matrix read:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Computing row sums using threads:");
        RowSumThread[] threads = new RowSumThread[m];
        for (int i = 0; i < m; i++) {
            threads[i] = new RowSumThread(matrix[i]);
            threads[i].setName(String.valueOf(i));
            threads[i].start();
        }

        for (int i = 0; i < m; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All row sums computed.");
        scanner.close();
    }
}