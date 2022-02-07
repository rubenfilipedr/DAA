/*
Escreva um programa que, dado um conjunto de N números, descubra para cada um
deles qual a menor quantidade de dígitos a adicionar a cada um deles para os
transformar numa capicua.
*/

import java.util.*;

class daa019 {


  public static int solve(int a[], int b[]) {
    int size = a.length;
    int m[][] = new int[size][size];
    int value;

    for (int i=0 ; i<size ; i++) m[i][0] = i;
    for (int j=0 ; j<size ; j++) m[0][j] = j;

    for (int i=1 ; i<size ; i++) {
      for (int j=1 ; j<size ; j++) {
        if (a[i] == b[j]) value = 0;
        else value = 1;
        m[i][j] = Math.min(m[i-1][j-1]+value, Math.min(m[i-1][j]+1, m[i][j-1]+1));
      }
    }

    return m[size-1][size-1];
  }



  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();              // quantidade de números a considerar
    String c[] = new String[n];              // número inicial a partir do qual se quer chegar à capicua
    for (int i=0 ; i<n ; i++) c[i] = in.next();

    for (int i=0 ; i<n ; i++) {
      int size = c[i].length();

      int a[] = new int[size+1];
      int b[] = new int[size+1];
      int k = 0;
      int ii = 1;
      int jj = size;

      while (k != size) {
        a[ii] = c[i].charAt(k) - '0';
        b[size+1-ii] = c[i].charAt(k) - '0';
        ii++;
        k++;
      }
      System.out.println(solve(a, b));
    }

  }


}
