import java.util.Scanner;

public class q11 {
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

        System.out.println("Matriz transposta:");
        imprimirTransposta(matriz);

        sc.close();
    }

    public static void imprimirTransposta(int[][] m) {
        for (int j = 0; j < m[0].length; j++) {
            for (int i = 0; i < m.length; i++) {
                System.out.print(m[i][j] + (i == m.length - 1 ? "" : " "));
            }
            System.out.println();
        }
    }
}