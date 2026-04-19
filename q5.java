import java.util.Scanner;

public class q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] producao = new int[n];

        for (int i = 0; i < n; i++) {
            producao[i] = sc.nextInt();
        }

        int maxProd = encontrarMax(producao);
        int minProd = encontrarMin(producao);
        int maxCresc = encontrarMaxCrescimento(producao);

        System.out.println("Maior producao: " + maxProd);
        System.out.println("Menor producao: " + minProd);
        System.out.println("Maior crescimento consecutivo: " + maxCresc);

        sc.close();
    }

    public static int encontrarMax(int[] v) {
        int max = v[0];
        for (int x : v) {
            if (x > max) max = x;
        }
        return max;
    }

    public static int encontrarMin(int[] v) {
        int min = v[0];
        for (int x : v) {
            if (x < min) min = x;
        }
        return min;
    }

    public static int encontrarMaxCrescimento(int[] v) {
        int maxC = 0;
        for (int i = 1; i < v.length; i++) {
            int diff = v[i] - v[i-1];
            if (diff > maxC) maxC = diff;
        }
        return maxC;
    }
}