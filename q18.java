import java.util.Scanner;

public class q18 {
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

        int count = contarPicos(matriz);
        int[] maxPeak = encontrarMaiorPico(matriz);

        System.out.println("Quantidade de pontos de pico: " + count);
        if (maxPeak[0] != -1) {
            System.out.println("Posicao do maior ponto de pico: " + maxPeak[1] + " " + maxPeak[2]);
            System.out.println("Valor do maior ponto de pico: " + maxPeak[0]);
        }

        sc.close();
    }

    public static int contarPicos(int[][] m) {
        int count = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (ehPico(m, i, j)) count++;
            }
        }
        return count;
    }

    public static int[] encontrarMaiorPico(int[][] m) {
        int maxVal = Integer.MIN_VALUE;
        int maxI = -1, maxJ = -1;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (ehPico(m, i, j) && m[i][j] > maxVal) {
                    maxVal = m[i][j];
                    maxI = i;
                    maxJ = j;
                }
            }
        }
        return new int[]{maxVal, maxI, maxJ};
    }

    public static boolean ehPico(int[][] m, int i, int j) {
        int l = m.length;
        int c = m[0].length;
        if (i > 0 && m[i][j] <= m[i-1][j]) return false;
        if (i < l-1 && m[i][j] <= m[i+1][j]) return false;
        if (j > 0 && m[i][j] <= m[i][j-1]) return false;
        if (j < c-1 && m[i][j] <= m[i][j+1]) return false;
        return true;
    }
}