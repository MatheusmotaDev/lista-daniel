import java.util.Scanner;

public class q9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] matriz = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = sc.nextInt();
            }
        }

        int somaPrincipal = somaDiagonalPrincipal(matriz);
        int somaSecundaria = somaDiagonalSecundaria(matriz);
        int total = somaTotalDiagonais(matriz);

        System.out.println("Soma da diagonal principal: " + somaPrincipal);
        System.out.println("Soma da diagonal secundaria: " + somaSecundaria);
        System.out.println("Soma total das diagonais sem repetir o centro: " + total);

        sc.close();
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

    public static int somaTotalDiagonais(int[][] m) {
        int n = m.length;
        int total = somaDiagonalPrincipal(m) + somaDiagonalSecundaria(m);
        if (n % 2 == 1) {
            total -= m[n/2][n/2];
        }
        return total;
    }
}