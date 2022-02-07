/*
Dada uma sequência de N números inteiros, a tua tarefa é calcular a maior soma
que uma sequência contígua de um ou mais números da sequência pode formar.
*/

import java.util.Scanner;

class daa007 {

  // subsequência de maior soma do array v[] entre as posições a e b
  public static int sms(int v[], int a, int b) {
    if (a == b) return v[a];        // se o array só tiver 1 elemento
    int meio = (a+b)/2;
    int best1 = sms(v, a, meio);    // melhor da primeira parte
    int best2 = sms(v, meio+1, b);  // melhor da segunda parte
    // verificar a melhor sequencia que começa na primeira parte e termina na segunda
    // a melhor subsequência da primeira parte começa no elemento + à direita da mesma
    // e vai somando com os elemento à esquerda. se a soma desses mesmos elementos for
    // maior do que a soma anteriormente guardada, então o valor "final" será o maior
    int bestFirst = 0;
    int tmpFirst = v[meio];
    if (tmpFirst > bestFirst) bestFirst = tmpFirst;
    for (int i=meio-1 ; i>=a ; i--) {
      tmpFirst += v[i];
      if (tmpFirst > bestFirst) bestFirst = tmpFirst;
    }
    // a melhor subsequência da segunda parte começa no elemento + à esquerda da mesma
    // e vai somando com os elemento à direita. se a soma desses mesmos elementos for
    // maior do que a soma anteriormente guardada, então o valor "final" será o maior
    int bestSecond = 0;
    int tmpSecond = v[meio+1];
    if (tmpSecond > bestSecond) bestSecond = tmpSecond;
    for (int i=meio+2 ; i<=b ; i++) {
      tmpSecond += v[i];
      if (tmpSecond > bestSecond) bestSecond = tmpSecond;
    }
    // somas das 2 melhores subsequências
    int best3 = bestFirst+bestSecond;
    return Math.max(best1, Math.max(best2, best3));
  }

  public static void main(String[] args) {
    FastScanner in = new FastScanner(System.in);

    int n = in.nextInt();   // quantidade de números na sequência
    int v[] = new int[n];   // sequência
    for (int i=0 ; i<n ; i++) {
      v[i] = in.nextInt();
    }
    FastPrint.out.println(sms(v, 0, n-1));
    FastPrint.out.close();
  }

}
