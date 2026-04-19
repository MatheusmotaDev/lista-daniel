import java.util.Scanner;
import java.util.Arrays;

public class q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double[] tempos = new double[n];

        for (int i = 0; i < n; i++) {
            tempos[i] = sc.nextDouble();
        }

        double minTempo = encontrarMin(tempos);
        double maxTempo = encontrarMax(tempos);

        System.out.println("Melhor tempo: " + minTempo);
        System.out.println("Pior tempo: " + maxTempo);
        System.out.println("Tres melhores tempos:");
        imprimirTresMelhores(tempos);

        sc.close();
    }

    public static double encontrarMin(double[] v) {
        double min = v[0];
        for (double x : v) {
            if (x < min) min = x;
        }
        return min;
    }

    public static double encontrarMax(double[] v) {
        double max = v[0];
        for (double x : v) {
            if (x > max) max = x;
        }
        return max;
    }

    public static void imprimirTresMelhores(double[] v) {
        double[] sorted = Arrays.copyOf(v, v.length);
        Arrays.sort(sorted);
        for (int i = 0; i < 3; i++) {
            System.out.print(sorted[i] + (i == 2 ? "" : " "));
        }
        System.out.println();
    }
}