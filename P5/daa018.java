/*
Escreva um programa que dado um conjunto de N moedas e uma série de P perguntas,
cada uma indicando uma quantia Qi, indique qual o menor número de moedas
necessário para fazer cada quantia, e quais as moedas a usar em cada caso.
*/

import java.util.*;

class daa018 {


  public static void solve(int t[], int k) {
    int coins[] = new int[k+1];
    int use[] = new int[k+1];
    for (int i=1 ; i<k+1 ; i++) {
      coins[i] = 100000;
      for (int j=0 ; j<t.length ; j++) {
        if (t[j] <= i && 1 + coins[i-t[j]] < coins[i]) {
          coins[i] = 1 + coins[i - t[j]];
          use[i] = t[j];
        }
      }
    }

    System.out.print(k + ": [" + coins[k] + "]");
    int amount = k;
    while (amount != 0) {
      System.out.print(" " + use[amount]);
      amount = amount - use[amount];
    }
    System.out.println();
  }




  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();       // número de tipos de moedas
    int t[] = new int[n];       // tipos de moedas
    for (int i=0 ; i<n ; i++) {
      t[i] = in.nextInt();
    }

    int p = in.nextInt();        // número de perguntas
    int q[] = new int[p];        // perguntas
    for (int i=0 ; i<p ; i++) q[i] = in.nextInt();
    for (int i=0 ; i<p ; i++) solve(t, q[i]);
  }


}
