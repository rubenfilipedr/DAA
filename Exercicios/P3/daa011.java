/*
Dado um conjunto de N distâncias, e P perguntas (queries), cada uma indicando um
número Ki de dias, a tua tarefa é calcular, para cada pergunta, qual o custo
ótimo, ou seja, qual o caminho que minimiza a maior distância num único dia, tal
com atrás explicado.
*/

import java.util.*;

class daa011 {


  public static int partition(int v[], int k, int low, int high) {
    while (low < high) {
      int middle = low + (high-low)/2;
      if (isPossible(v, k, middle)) high = middle;
      else low = middle+1;
    }
    if (!isPossible(v, k, low)) return -1;
    return low;
  }


  public static boolean isPossible(int v[], int k, int x) {
    int partitions = 1;
    int sum = 0;
    for (int i=0 ; i<v.length ; i++) {
      if (v[i] > x) return false;
      if (sum+v[i] > x) {
        partitions++;
        sum = v[i];
      } else {
        sum += v[i];
      }
    }
    return (partitions <= k);
  }


  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();         // quantidade de distâncias a considerar
    int d[] = new int[n];         // array para guardar as distâncias
    for (int i=0 ; i<n ; i++) {   // distâncias
      d[i] = in.nextInt();
    }
    int p = in.nextInt();         // quantidade de perguntas
    int k[] = new int[p];         // array para guardar o número de dias em que devem dividir o percurso
    for (int i=0 ; i<p ; i++) {   // perguntas
      k[i] = in.nextInt();
    }
    int biggerSum = Arrays.stream(d).sum();
    for (int i=0 ; i<p ; i++) {
      System.out.println(partition(d, k[i], 1, biggerSum));
    }

  }

}
