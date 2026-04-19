import java.util.Scanner;

public class q16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] matriz = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = sc.nextInt();
            }
        }

        int[] saidas = calcularSaidas(matriz);
        int[] chegadas = calcularChegadas(matriz);

        for (int i = 0; i < n; i++) {
            System.out.println("Saidas do terminal " + i + ": " + saidas[i]);
        }

        for (int j = 0; j < n; j++) {
            System.out.println("Chegadas no terminal " + j + ": " + chegadas[j]);
        }

        int idxMaxDiff = encontrarTerminalMaiorDiferenca(saidas, chegadas);
        System.out.println("Terminal com maior diferenca absoluta entre saidas e chegadas: " + idxMaxDiff);

        boolean simetrica = verificarSimetrica(matriz);
        System.out.println("Matriz simetrica: " + (simetrica ? "sim" : "nao"));

        sc.close();
    }

    public static int[] calcularSaidas(int[][] m) {
        int[] saidas = new int[m.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                saidas[i] += m[i][j];
            }
        }
        return saidas;
    }

    public static int[] calcularChegadas(int[][] m) {
        int[] chegadas = new int[m.length];
        for (int j = 0; j < m.length; j++) {
            for (int i = 0; i < m.length; i++) {
                chegadas[j] += m[i][j];
            }
        }
        return chegadas;
    }

    public static int encontrarTerminalMaiorDiferenca(int[] saidas, int[] chegadas) {
        int maxDiff = 0;
        int idx = 0;
        for (int i = 0; i < saidas.length; i++) {
            int diff = Math.abs(saidas[i] - chegadas[i]);
            if (diff > maxDiff) {
                maxDiff = diff;
                idx = i;
            }
        }
        return idx;
    }

    public static boolean verificarSimetrica(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (m[i][j] != m[j][i]) return false;
            }
        }
        return true;
    }
}