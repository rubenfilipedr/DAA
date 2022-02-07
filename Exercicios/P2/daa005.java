/*
Dada uma sequência de N bakugans, descrita pelas energias Ei de cada um deles,
bem como uma série de F fotos, cada uma indicando que contém os bakugans entre
as posições Ai e Bi, a tua tarefa é calcular, para cada foto, a soma das energias
dos bakugans com posições no intervalo [Ai, Bi]
*/

import java.util.Scanner;


public class daa005 {


  public static void main(String[] args) {

    FastScanner in = new FastScanner(System.in);

    int n = in.nextInt();   // nº de bakugans
    int ac[] = new int[n+1];    // acumulador
    for (int i=0 ; i<n ; i++) {
      ac[i+1] = ac[i] + in.nextInt();
    }

    int f = in.nextInt();   // nº de fotos
    for (int i=0 ; i<f ; i++) {   // posições dos bakugans na foto
      int ini = in.nextInt();   // posição inicial da foto
      int end = in.nextInt();   // posição final da foto
      FastPrint.out.println(ac[end] - ac[ini-1]);
    }
    FastPrint.out.close();


/*
    for (int i=0 ; i<f ; i++) {
      int sum = 0;
      for (int j=0 ; j<n ; j++) {
        if ((j+1)>=inPos[i] && (j+1)<=endPos[i]) {
          sum += energy[j];
        }
      }
      System.out.println(sum);
    }
*/
  }


}
