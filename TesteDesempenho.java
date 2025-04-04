import java.util.Scanner;
public class TesteDesempenho {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        NossoVetor vetorTeste;
        int t;
        int e;
        int qtdTestes;

        System.out.println("Tamanho do Vetor: ");
        t = scanner.nextInt();
        System.out.println("Elemento a ser buscado: ");
        e = scanner.nextInt();
        System.out.println("Quantidade de Testes: ");
        qtdTestes = scanner.nextInt();

        for (int i = 1; i < qtdTestes + 1; i++) {
            vetorTeste = new NossoVetor(t);
            System.out.printf("\nBateria de Testes %d \n", i);

            vetorTeste.preencheVetor();
            System.out.println(vetorTeste.buscaLinear(e));
            System.out.println(vetorTeste.bubbleSort());
            System.out.println(vetorTeste.buscaBinaria(e) + "\n");   

            vetorTeste.preencheVetor();
            System.out.println(vetorTeste.buscaLinear(e));
            System.out.println(vetorTeste.selectionSort());
            System.out.println(vetorTeste.buscaBinaria(e) + "\n");

            vetorTeste.preencheVetor();
            System.out.println(vetorTeste.buscaLinear(e));
            System.out.println(vetorTeste.insertionSort());
            System.out.println(vetorTeste.buscaBinaria(e) + "\n");

        }

        scanner.close();

    }
}