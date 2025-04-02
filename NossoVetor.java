import java.util.Random;
public class NossoVetor {
  private int ocupacao;
  private int[] vetor;

  public NossoVetor(int tamanho) {
    vetor = new int[tamanho];
    ocupacao = 0;
  }

  public NossoVetor() {
    this(10);
  }

  public void inserir(int i) {
    if (estaCheio())
      redimensiona(vetor.length * 2);
    vetor[ocupacao++] = i;
  }
  public int remover() {
    if (estaVazio()) {
        throw new VetorVazioException("vetor vazio, nao há o que remover");
    }
    int aux = vetor[--ocupacao];
    if (vetor.length >= 6 && ocupacao <= vetor.length / 4) {
        redimensiona(vetor.length / 2);
    }
    return aux;
  }
  public boolean estaCheio() {
    return ocupacao == vetor.length;
  }

  public boolean estaVazio() {
    return ocupacao == 0;
  }
  private void redimensiona(int novoTamanho) {
    int[] temp = new int[novoTamanho];
    for (int i = 0; i < ocupacao; i++) {
      temp[i] = vetor[i];
    }
    vetor = temp;
  }
  public int getTamanho() {
    return vetor.length;
  }
  public void preecheVetor () {
    Random random = new Random();
    for (int i=0; i<vetor.length; i++) {
      vetor[i] = random.nextInt(vetor.length * 10);
    }
    ocupacao = vetor.length;
  }
  public boolean contem (int i) {
    for (int j=0; j < ocupacao; j++)
      if (vetor[j] == i)
        return true;
    return false;
  }
  public int indiceDe (int i) {
    for (int j=0; j < ocupacao; j++)
      if (vetor[j] == i)
        return j;
    return -1;
  }
  public void bubbleSort () {
    for (int i=1; i<vetor.length; i++) {
      for (int j=0; j < vetor.length - i; j++) {
        if (vetor[j] > vetor[j+1]) {
          int aux = vetor[j];
          vetor[j] = vetor[j+1];
          vetor[j+1] = aux;
        }
      }
    }
  }
  public void selectionSort ()
  {
     for (int i = 0; i < vetor.length-1; ++i) {
        int min = i;
        for (int j = i+1; j < vetor.length; ++j)
           if (vetor[j] < vetor[min])  min = j;
        int x = vetor[i]; 
        vetor[i] = vetor[min]; 
        vetor[min] = x;
     }
  }
  public void insertionSort ()
  {
     for (int j = 1; j < vetor.length; ++j) {
        int x = vetor[j];
        int i;
        for (i = j-1; i >= 0 && vetor[i] > x; --i) 
           vetor[i+1] = vetor[i];
        vetor[i+1] = x;
     }
  }
  public int buscaLinear(int elemento) {
    int contadorL = 0;
    for (int i = 0; i < vetor.length; i++) {
      contadorL++;
      if (vetor[i] == elemento) {
        return contadorL;
      }
    }
    return contadorL;
  }

  public int buscaBinaria(int elemento) {
    int contadorB = 0;
    int inicio = 0;
    int fim = vetor.length - 1;
    while (inicio <= fim) {
      
      int meio = inicio + (fim - inicio) / 2;
      contadorB++;
      if (elemento == vetor[meio]) {
        return contadorB;
      }
      if (elemento > vetor[meio]) {
        inicio = meio + 1;
      } else {
        fim = meio - 1;
      }
    }
    return contadorB;
  }
}

class VetorVazioException extends RuntimeException {
  public VetorVazioException(String msg) {
    super(msg);
  }
}