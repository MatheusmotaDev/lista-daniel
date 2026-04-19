import java.util.Scanner;

public class q15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] matriz = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = sc.nextInt();
            }
        }

        boolean diagonalZero = verificarDiagonalZero(matriz);
        System.out.println("Diagonal principal com zeros: " + (diagonalZero ? "sim" : "nao"));

        int[] maxOff = encontrarMaxForaDiagonal(matriz);
        System.out.println("Maior valor fora da diagonal: " + maxOff[0] + " (" + maxOff[1] + "," + maxOff[2] + ")");

        int idxMin = encontrarIndiceMinSomaLinha(matriz);
        System.out.println("Linha com menor soma: " + idxMin);

        sc.close();
    }

    public static boolean verificarDiagonalZero(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            if (m[i][i] != 0) return false;
        }
        return true;
    }

    public static int[] encontrarMaxForaDiagonal(int[][] m) {
        int max = Integer.MIN_VALUE;
        int maxI = -1, maxJ = -1;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (i != j && m[i][j] > max) {
                    max = m[i][j];
                    maxI = i;
                    maxJ = j;
                }
            }
        }
        return new int[]{max, maxI, maxJ};
    }

    public static int encontrarIndiceMinSomaLinha(int[][] m) {
        int[] somas = new int[m.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                somas[i] += m[i][j];
            }
        }
        int min = somas[0];
        int idx = 0;
        for (int i = 1; i < somas.length; i++) {
            if (somas[i] < min) {
                min = somas[i];
                idx = i;
            }
        }
        return idx;
    }
}