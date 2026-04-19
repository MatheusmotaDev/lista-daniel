import java.util.Scanner;

public class q8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int l = sc.nextInt();
        int c = sc.nextInt();
        double[][] notas = new double[l][c];

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {
                notas[i][j] = sc.nextDouble();
            }
        }

        double[] mediasAlunos = calcularMediasAlunos(notas);
        for (int i = 0; i < l; i++) {
            System.out.printf("Media do aluno %d: %.2f\n", i, mediasAlunos[i]);
        }

        double[] mediasAvaliacoes = calcularMediasAvaliacoes(notas);
        for (int j = 0; j < c; j++) {
            System.out.printf("Media da avaliacao %d: %.2f\n", j, mediasAvaliacoes[j]);
        }

        int aprovados = contarAprovados(notas);
        System.out.println("Quantidade de alunos aprovados: " + aprovados);

        sc.close();
    }

    public static double[] calcularMediasAlunos(double[][] m) {
        double[] medias = new double[m.length];
        for (int i = 0; i < m.length; i++) {
            double soma = 0;
            for (int j = 0; j < m[i].length; j++) {
                soma += m[i][j];
            }
            medias[i] = soma / m[i].length;
        }
        return medias;
    }

    public static double[] calcularMediasAvaliacoes(double[][] m) {
        double[] medias = new double[m[0].length];
        for (int j = 0; j < m[0].length; j++) {
            double soma = 0;
            for (int i = 0; i < m.length; i++) {
                soma += m[i][j];
            }
            medias[j] = soma / m.length;
        }
        return medias;
    }

    public static int contarAprovados(double[][] m) {
        int count = 0;
        for (int i = 0; i < m.length; i++) {
            double soma = 0;
            for (int j = 0; j < m[i].length; j++) {
                soma += m[i][j];
            }
            double media = soma / m[i].length;
            if (media >= 7.0) count++;
        }
        return count;
    }
}