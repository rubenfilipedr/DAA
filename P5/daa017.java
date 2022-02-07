/*
Escreva um programa que dada uma pirâmide com N camadas, e uma descrição das
pedras em falta ou muito deterioradas numa das faces da pirâmide, calcule o
número de maneiras diferentes de subir a pirâmide até ao topo, começando por
uma qualquer das pedras da primeira camada, evitando as pedras que estão em
falta ou muito deterioradas.
*/

import java.util.*;


class daa017 {


  public static long solve(long v[][]) {
    for (int i=2 ; i<v.length ; i++) {
      for (int j=1 ; j<=v.length-i ; j++) {
        if (v[i][j] == 1) v[i][j] = v[i-1][j] + v[i-1][j+1];
      }
    }
    return v[v.length-1][1];
  }



  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();             // número de pedras na 1ª camada (nº de camadas)
    long v[][] = new long[n+1][n+1];    // [camada][pedra]
    for (int i=1 ; i<v.length ; i++) {
      for (int j=1 ; j<v.length ; j++) v[i][j] = 1;
    }
    int d = in.nextInt();             // pedras em falta ou deterioradas
    for (int i=0 ; i<d ; i++) {
      v[in.nextInt()][in.nextInt()] = 0;    // 1 se estiver deteriorada
    }
    System.out.println(solve(v));
  }


}
