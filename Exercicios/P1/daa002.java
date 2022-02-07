/*
Dados vários pares de inteiros Ni e Ki, a tua tarefa é descobrir, para cada par,
 qual o menor número maior que Ni tal que a soma dos seus dígitos seja exactamente Ki.
*/

import java.util.Scanner;

public class daa002 {

  public static int Sum(int n) {
    int number = n;
    int sum = 0;
    int nSize = Integer.toString(n).length();
    for (int i=0 ; i<nSize ; i++) {
      sum += (number%10);
      number /= 10;
    }
    return sum;
  }

  public static void main (String[] args) {
    Scanner in = new Scanner(System.in);

    int t = in.nextInt();    // nº de testes
    int v[] = new int[t*2]; 
    for (int i=0 ; i<(t*2) ; i++) {
      v[i] = in.nextInt();
      if (i%2 == 0) { v[i] += 1; }
    }

    for (int i=0 ; i<(t*2) ; i+=2) {
      while (Sum(v[i]) != v[i+1]) { v[i]++; }
      System.out.println(v[i]);
    }

  }

}
