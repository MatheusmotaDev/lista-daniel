import java.util.Scanner;

public class q7 {
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

        int[] somas = calcularSomasLinhas(matriz);
        int maxSoma = encontrarMax(somas);

        for (int i = 0; i < l; i++) {
            System.out.println("Soma da linha " + i + ": " + somas[i]);
        }

        System.out.println("Maior soma: " + maxSoma);

        sc.close();
    }

    public static int[] calcularSomasLinhas(int[][] m) {
        int[] somas = new int[m.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                somas[i] += m[i][j];
            }
        }
        return somas;
    }

    public static int encontrarMax(int[] v) {
        int max = v[0];
        for (int x : v) {
            if (x > max) max = x;
        }
        return max;
    }
}