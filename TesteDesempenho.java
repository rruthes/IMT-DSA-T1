import java.util.Calendar;
import java.util.Scanner;

public class TesteDesempenho {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NossoVetor v;
        int t;
        int e;
        System.out.println("elemento a ser buscado: ");
        e = scanner.nextInt();
        System.out.print("digite o tamanho do vetor, 0 encerra: ");
        t = scanner.nextInt();
        while (t > 0) {
            v = new NossoVetor(t);

            v.preecheVetor();
            System.out.println(v.buscaLinear(e));
            long ini = Calendar.getInstance().getTimeInMillis();
            v.bubbleSort();
            long fim = Calendar.getInstance().getTimeInMillis();
            System.out.println("bubble demorou " + (fim - ini) + " milissegundos");
            System.out.println(v.buscaBinaria(e));

            v.preecheVetor();
            System.out.println(v.buscaLinear(e));
            ini = Calendar.getInstance().getTimeInMillis();
            v.selectionSort();
            fim = Calendar.getInstance().getTimeInMillis();
            System.out.println("selection demorou " + (fim - ini) + " milissegundos");
            System.out.println(v.buscaBinaria(e));

            v.preecheVetor();
            System.out.println(v.buscaLinear(e));
            ini = Calendar.getInstance().getTimeInMillis();
            v.insertionSort();
            fim = Calendar.getInstance().getTimeInMillis();
            System.out.println("insertion demorou " + (fim - ini) + " milissegundos");
            System.out.println(v.buscaBinaria(e));

            ini = Calendar.getInstance().getTimeInMillis();
            v.bubbleSort();
            fim = Calendar.getInstance().getTimeInMillis();
            System.out.println("bubble ordenado demorou " + (fim - ini) + " milissegundos");

            ini = Calendar.getInstance().getTimeInMillis();
            v.selectionSort();
            fim = Calendar.getInstance().getTimeInMillis();
            System.out.println("selection ordenado demorou " + (fim - ini) + " milissegundos");

            ini = Calendar.getInstance().getTimeInMillis();
            v.insertionSort();
            fim = Calendar.getInstance().getTimeInMillis();
            System.out.println("insertion ordenado demorou " + (fim - ini) + " milissegundos");
            
            System.out.print("\ndigite o novo tamanho, 0 encerra: ");
            t = scanner.nextInt();
        }
        scanner.close();
    }
}