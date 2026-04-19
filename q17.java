import java.util.Scanner;

public class q17 {
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

        int[] maxRow = encontrarMaxContiguoLinha(matriz);
        int[] maxCol = encontrarMaxContiguoColuna(matriz);

        System.out.println("Maior soma contigua em linha: " + maxRow[0]);
        System.out.println("Linha da maior soma contigua: " + maxRow[1]);
        System.out.println("Maior soma contigua em coluna: " + maxCol[0]);
        System.out.println("Coluna da maior soma contigua: " + maxCol[1]);

        sc.close();
    }

    public static int[] encontrarMaxContiguoLinha(int[][] m) {
        int maxSum = Integer.MIN_VALUE;
        int maxIdx = 0;
        for (int i = 0; i < m.length; i++) {
            int currentMax = m[i][0];
            int globalMax = m[i][0];
            for (int j = 1; j < m[i].length; j++) {
                currentMax = Math.max(m[i][j], currentMax + m[i][j]);
                if (currentMax > globalMax) globalMax = currentMax;
            }
            if (globalMax > maxSum) {
                maxSum = globalMax;
                maxIdx = i;
            }
        }
        return new int[]{maxSum, maxIdx};
    }

    public static int[] encontrarMaxContiguoColuna(int[][] m) {
        int maxSum = Integer.MIN_VALUE;
        int maxIdx = 0;
        for (int j = 0; j < m[0].length; j++) {
            int currentMax = m[0][j];
            int globalMax = m[0][j];
            for (int i = 1; i < m.length; i++) {
                currentMax = Math.max(m[i][j], currentMax + m[i][j]);
                if (currentMax > globalMax) globalMax = currentMax;
            }
            if (globalMax > maxSum) {
                maxSum = globalMax;
                maxIdx = j;
            }
        }
        return new int[]{maxSum, maxIdx};
    }
}