import java.util.Scanner;

public class q19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] matriz = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = sc.nextInt();
            }
        }

        int[] rowSums = calcularSomasLinhas(matriz);
        int[] colSums = calcularSomasColunas(matriz);
        int diag1 = somaDiagonalPrincipal(matriz);
        int diag2 = somaDiagonalSecundaria(matriz);

        boolean consistent = verificarConsistencia(rowSums, colSums, diag1, diag2);
        if (consistent) {
            System.out.println("Matriz consistente: sim");
            System.out.println("Valor comum das somas: " + rowSums[0]);
        } else {
            System.out.println("Matriz consistente: nao");
            int countDiff = contarEstruturasDiferentes(rowSums, colSums, diag1, diag2);
            System.out.println("Quantidade de estruturas com soma diferente da primeira linha: " + countDiff);
        }

        sc.close();
    }

    public static int[] calcularSomasLinhas(int[][] m) {
        int[] somas = new int[m.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                somas[i] += m[i][j];
            }
        }
        return somas;
    }

    public static int[] calcularSomasColunas(int[][] m) {
        int[] somas = new int[m.length];
        for (int j = 0; j < m.length; j++) {
            for (int i = 0; i < m.length; i++) {
                somas[j] += m[i][j];
            }
        }
        return somas;
    }

    public static int somaDiagonalPrincipal(int[][] m) {
        int soma = 0;
        for (int i = 0; i < m.length; i++) {
            soma += m[i][i];
        }
        return soma;
    }

    public static int somaDiagonalSecundaria(int[][] m) {
        int soma = 0;
        int n = m.length;
        for (int i = 0; i < n; i++) {
            soma += m[i][n-1-i];
        }
        return soma;
    }

    public static boolean verificarConsistencia(int[] rowSums, int[] colSums, int diag1, int diag2) {
        int target = rowSums[0];
        for (int sum : rowSums) if (sum != target) return false;
        for (int sum : colSums) if (sum != target) return false;
        if (diag1 != target || diag2 != target) return false;
        return true;
    }

    public static int contarEstruturasDiferentes(int[] rowSums, int[] colSums, int diag1, int diag2) {
        int target = rowSums[0];
        int count = 0;
        for (int sum : rowSums) if (sum != target) count++;
        for (int sum : colSums) if (sum != target) count++;
        if (diag1 != target) count++;
        if (diag2 != target) count++;
        return count;
    }
}