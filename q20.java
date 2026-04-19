import java.util.Scanner;

public class q20 {
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

        int k = sc.nextInt();

        int[] seq = encontrarMaiorSequenciaAcimaDe(matriz, k);

        System.out.println("Maior sequencia acima de " + k + ": " + seq[0]);
        System.out.println("Linha da sequencia: " + seq[1]);
        System.out.println("Indice inicial: " + seq[2]);
        System.out.println("Indice final: " + seq[3]);

        sc.close();
    }

    public static int[] encontrarMaiorSequenciaAcimaDe(int[][] m, int k) {
        int maxLen = 0;
        int maxRow = 0;
        int maxStart = 0;
        int maxEnd = 0;

        for (int i = 0; i < m.length; i++) {
            int currentLen = 0;
            int start = 0;
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] > k) {
                    if (currentLen == 0) start = j;
                    currentLen++;
                    if (currentLen > maxLen) {
                        maxLen = currentLen;
                        maxRow = i;
                        maxStart = start;
                        maxEnd = j;
                    }
                } else {
                    currentLen = 0;
                }
            }
        }

        return new int[]{maxLen, maxRow, maxStart, maxEnd};
    }
}