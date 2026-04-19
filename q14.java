import java.util.Scanner;

public class q14 {
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

        int[] somaLinhas = calcularSomasLinhas(matriz);
        int[] somaColunas = calcularSomasColunas(matriz);
        double media = calcularMedia(matriz);

        int idxMaxLinha = encontrarIndiceMax(somaLinhas);
        int idxMinColuna = encontrarIndiceMin(somaColunas);
        int count = contarAcimaDaMedia(matriz, media);

        System.out.println("Linha com maior soma: " + idxMaxLinha);
        System.out.println("Coluna com menor soma: " + idxMinColuna);
        System.out.printf("Media geral: %.2f\n", media);
        System.out.println("Quantidade acima da media: " + count);

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

    public static int[] calcularSomasColunas(int[][] m) {
        int[] somas = new int[m[0].length];
        for (int j = 0; j < m[0].length; j++) {
            for (int i = 0; i < m.length; i++) {
                somas[j] += m[i][j];
            }
        }
        return somas;
    }

    public static double calcularMedia(int[][] m) {
        int total = 0;
        for (int[] row : m) {
            for (int x : row) {
                total += x;
            }
        }
        return (double) total / (m.length * m[0].length);
    }

    public static int encontrarIndiceMax(int[] v) {
        int max = v[0];
        int idx = 0;
        for (int i = 1; i < v.length; i++) {
            if (v[i] > max) {
                max = v[i];
                idx = i;
            }
        }
        return idx;
    }

    public static int encontrarIndiceMin(int[] v) {
        int min = v[0];
        int idx = 0;
        for (int i = 1; i < v.length; i++) {
            if (v[i] < min) {
                min = v[i];
                idx = i;
            }
        }
        return idx;
    }

    public static int contarAcimaDaMedia(int[][] m, double media) {
        int count = 0;
        for (int[] row : m) {
            for (int x : row) {
                if (x > media) count++;
            }
        }
        return count;
    }
}