import java.util.Scanner;

public class q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] consumos = new int[n];

        for (int i = 0; i < n; i++) {
            consumos[i] = sc.nextInt();
        }

        int total = calcularTotal(consumos);
        double media = (double) total / n;
        int diasAcima = contarDiasAcimaMedia(consumos, media);

        System.out.println("Consumo total: " + total);
        System.out.println("Consumo medio: " + media);
        System.out.println("Dias acima da media: " + diasAcima);

        sc.close();
    }

    public static int calcularTotal(int[] vetor) {
        int soma = 0;
        for (int v : vetor) {
            soma += v;
        }
        return soma;
    }

    public static int contarDiasAcimaMedia(int[] vetor, double media) {
        int cont = 0;
        for (int v : vetor) {
            if (v > media) {
                cont++;
            }
        }
        return cont;
    }
}