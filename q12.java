import java.util.Scanner;

public class q12 {
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

        int r = sc.nextInt();
        int s = sc.nextInt();

        if (l * c != r * s) {
            System.out.println("Reorganizacao impossivel");
        } else {
            System.out.println("Matriz reorganizada:");
            imprimirReorganizada(matriz, r, s);
        }

        sc.close();
    }

    public static void imprimirReorganizada(int[][] m, int r, int s) {
        int idx = 0;
        int c = m[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < s; j++) {
                int row = idx / c;
                int col = idx % c;
                System.out.print(m[row][col] + (j == s - 1 ? "" : " "));
                idx++;
            }
            System.out.println();
        }
    }
}