/*
Dada uma sequência de N números inteiros, a tua tarefa é calcular a frequência
do número 42, ou seja, quantas vezes ocorre o número 42 na sequência que te é dada.
*/

import java.util.Scanner;

public class daa001 {

  public static void main (String[] args) {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();
    int count = 0;
    for (int i=0 ; i<n ; i++) {
      int s = in.nextInt();
      if (s == 42) count++;
    }

    System.out.println(count);
  }

}
