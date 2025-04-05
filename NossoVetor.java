// import java.util.Calendar;

import java.util.Random;

public class NossoVetor {

    private int[] vetor;
    private int ocupacao;

    public NossoVetor(int tamanho) {
        vetor = new int[tamanho];
        ocupacao = 0;
    }

    public boolean estaVazio() {
        return ocupacao == 0;
    }

    public void preencheVetor() {
        Random random = new Random();
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = random.nextInt(vetor.length * 1);

        }
        ocupacao = vetor.length;
    }

    public long bubbleSort() {
        long contador = 0;
        for (int i = 1; i < vetor.length; i++) {
            for (int j = 0; j < vetor.length - i; j++) {
                contador++; 
                if (vetor[j] > vetor[j + 1]) {
                    int aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                    contador += 3; 
                }
            }
        }
        return contador;
    }
    
    public long selectionSort() {
        long contador = 0;
        for (int i = 0; i < vetor.length - 1; ++i) {
            int min = i;
            for (int j = i + 1; j < vetor.length; ++j) {
                contador++; 
                if (vetor[j] < vetor[min])
                    min = j;
                    contador++; 
            }
            int x = vetor[i];
            vetor[i] = vetor[min];
            vetor[min] = x;
            contador += 3; 
        }
        return contador;
    }
    
    public long insertionSort() {
        long contador = 0;
        for (int j = 1; j < vetor.length; ++j) {
            int x = vetor[j];
            contador++; 
            int i;
            for (i = j - 1; i >= 0 && vetor[i] > x; --i) {
                contador++; 
                vetor[i + 1] = vetor[i];
                contador++; 
            }
            vetor[i + 1] = x;
            contador++; 
        }
        return contador;
    }

    public int buscaLinear(int elemento) {
        int contadorLinear = 0;

        for (int i = 0; i < vetor.length; i++) {
            contadorLinear++;
            if (vetor[i] == elemento) {
                return contadorLinear;
            }
        }
        return contadorLinear;
    }

    public int buscaBinaria(int elemento) {
        int contadorBinario = 0; 

        int inicio = 0;
        int fim = vetor.length - 1;
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            contadorBinario++;
            if (elemento == vetor[meio]) {
                return contadorBinario;
            }
            contadorBinario++;
            if (elemento > vetor[meio]) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return contadorBinario;
    }

    @Override
    public String toString() {
        String s = "ocupacao = " + ocupacao + "\n";
        for (int i = 0; i < ocupacao; i++) {
            s += vetor[i] + " ";
        }
        return s + "\n";
    }
}