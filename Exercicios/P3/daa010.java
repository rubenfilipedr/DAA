/*
Dada um conjunto S de N números inteiros, e uma sequência de Q perguntas (queries),
cada uma indicando um número Pi, a tua tarefa é descobrir qual é a soma de dois
números diferentes de S que está mais próxima do número Pi de cada pergunta.
*/

import java.util.Scanner;
import java.util.Arrays;


class daa010 {

  public static int bsearch(int v[], int low, int high, int key) {
    while (low < high) {
      int middle = low + (high-low)/2;
      if (v[middle] >= key) { high = middle; }
      else { low = middle+1; }
    }
    if (!(v[low] >= key)) return -1;
    return low;
  }


  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();         // tamanho do conjunto S de números
    int v[] = new int[n];
    for (int i=0 ; i<n ; i++) {   // números Si do conjunto
      v[i] = in.nextInt();
    }
    int q = in.nextInt();         // quantidade de perguntas
    int p[] = new int[q];
    for (int i=0 ; i<q ; i++) {   // perguntas
      p[i] = in.nextInt();
    }

    int pares = (n*(n-1))/2;  // quantidade de pares
    int somas[] = new int[pares];    // guardar todos os valores das somas
    int k = 0;
    for (int i=0 ; i<n-1 ; i++) {
      for (int j=i+1 ; j<n ; j++) {
        somas[k++] = v[i] + v[j];
      }
    }
    Arrays.sort(somas);              // ordenação do array

    for (int i=0 ; i<q ; i++) {
      int tmp = bsearch(somas, 0, k-2, p[i]);

      if (tmp > 0) {                                                          // Encontrou posição com valor menor do que p[i]
        if ( Math.abs(somas[tmp]-p[i]) < Math.abs(somas[tmp-1]-p[i]))         // Verificar qual está mais próxima do p[i]
          System.out.println(somas[tmp]);                                     // se é a que está abaixo de p[i], ou a que está acima
        else if ( Math.abs(somas[tmp]-p[i]) > Math.abs(somas[tmp-1]-p[i]) )   // Por exemplo, p[i] = 20
          System.out.println(somas[tmp-1]);                                   // somas[tmp] = 19 e somas [tmp+1] = 23
        else                                                                  // O resultado deve ser 20 pois (|20-19|<|20-23|)
          System.out.println(somas[tmp-1] + " " + somas[tmp]);
      } else if (tmp == -1) {                                                 // Se não encontrou valor maior do que p[i]
        if ( Math.abs(somas[k-1]-p[i]) < Math.abs(somas[k-2]-p[i]))           // Verificar qual dos 2 últimos valores do array somas
          System.out.println(somas[k-1]);                                     // está mais próximo de p[i]
        else if ( Math.abs(somas[k-1]-p[i]) > Math.abs(somas[k-2]-p[i]) )     // Ou é o penúltimo valor (foi até ao qual procuramos)
          System.out.println(somas[k-2]);                                     // Ou é o último valor
        else
          System.out.println(somas[k-2] + " " + somas[k-1]);
      } else {                                                                // Se tmp == 0, significa que o primeiro valor do
        System.out.println(somas[tmp]);                                       // array somas é maior do que p[i]
      }
    }
  }


}
