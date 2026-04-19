import java.util.Scanner;

public class q13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int l = sc.nextInt();
        int c = sc.nextInt();
        int[][] matriz = new int[l][c];

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                matriz[i][j] = sc.nextInt();
            }
        }

        int k = sc.nextInt();

        double avg = calcularMedia(matriz);
        int max = encontrarMax(matriz);
        int count = contarAcimaDe(matriz, k);

        System.out.printf("Media dos elementos: %.2f\n", avg);
        System.out.println("Maior elemento: " + max);
        System.out.println("Quantidade acima de " + k + ": " + count);

        sc.close();
    }

    public static double calcularMedia(int[][] m) {
        int sum = 0;
        for (int[] row : m) {
            for (int x : row) {
                sum += x;
            }
        }
        return (double) sum / (m.length * m[0].length);
    }

    public static int encontrarMax(int[][] m) {
        int max = Integer.MIN_VALUE;
        for (int[] row : m) {
            for (int x : row) {
                if (x > max) max = x;
            }
        }
        return max;
    }

    public static int contarAcimaDe(int[][] m, int k) {
        int count = 0;
        for (int[] row : m) {
            for (int x : row) {
                if (x > k) count++;
            }
        }
        return count;
    }
}