import java.util.Scanner;

public class q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double[] precos = new double[n];

        for (int i = 0; i < n; i++) {
            precos[i] = sc.nextDouble();
        }

        int p = sc.nextInt();

        double totalAntes = calcularTotal(precos);
        double[] novosPrecos = aplicarReajuste(precos, p);
        double totalDepois = calcularTotal(novosPrecos);

        System.out.println("Novos precos:");
        for (int i = 0; i < n; i++) {
            System.out.print(novosPrecos[i] + (i == n - 1 ? "" : " "));
        }
        System.out.println();

        System.out.println("Total antes do reajuste: " + totalAntes);
        System.out.println("Total depois do reajuste: " + totalDepois);

        sc.close();
    }

    public static double calcularTotal(double[] v) {
        double s = 0;
        for (double x : v) {
            s += x;
        }
        return s;
    }

    public static double[] aplicarReajuste(double[] v, int p) {
        double[] novos = new double[v.length];
        for (int i = 0; i < v.length; i++) {
            novos[i] = v[i] * (1 + (double) p / 100);
        }
        return novos;
    }
}