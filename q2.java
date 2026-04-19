import java.util.Scanner;

public class q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double[] notas = new double[n];

        for (int i = 0; i < n; i++) {
            notas[i] = sc.nextDouble();
        }

        double maior = buscarMaior(notas);
        double menor = buscarMenor(notas);
        double media = calcularMedia(notas);
        int aprovados = contarAprovados(notas);

        System.out.println("Maior nota: " + maior);
        System.out.println("Menor nota: " + menor);
        System.out.println("Media da turma: " + media);
        System.out.println("Quantidade de aprovados: " + aprovados);

        sc.close();
    }

    public static double buscarMaior(double[] v) {
        double m = v[0];
        for (double x : v) {
            if (x > m) m = x;
        }
        return m;
    }

    public static double buscarMenor(double[] v) {
        double m = v[0];
        for (double x : v) {
            if (x < m) m = x;
        }
        return m;
    }

    public static double calcularMedia(double[] v) {
        double s = 0;
        for (double x : v) {
            s += x;
        }
        return s / v.length;
    }

    public static int contarAprovados(double[] v) {
        int c = 0;
        for (double x : v) {
            if (x >= 7.0) c++;
        }
        return c;
    }
}