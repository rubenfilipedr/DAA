/*
Dado o número de balões e as suas alturas, a tua tarefa é calcular qual o menor
número de flechas que a Maria precisa de disparar para rebentar todos os balões.
*/

import java.util.*;

class daa015 {

  public static int solve(int v[]) {      // array v[] guarda as alturas
    FastScanner in = new FastScanner(System.in);

    int terminator = 0;                   // -> var. que controla o número de balões rebentados
    int arrows = 0;                       // -> número de flechas
    int i = 0;                            // -> var. fixada num balão
    int j = 1;                            // -> var. que se movimenta em busca de um balão com altura
                                          // v[i]-1 == v[j]
    int k = 0;                            // -> guarda a posição após o i;
    while (terminator != v.length) {      // -> enquanto o número de balões rebentados for menor que o
                                          // número de balões
      if (j == v.length) {                // -> se o j alcançou um valor igual ao tamanho do array
                                          // significa que não existe mais balões após este logo
                                          // o balão i seria o última a ser rebentado por essa flecha
        v[i] = 0;                         // -> balão rebentado
        terminator++;                     // -> +1 balão rebentado
        i = k;                            // -> i passa para a posição+1 do i inicial
        j = i+1;                          // -> j procura balões para a frente do i
        arrows++;                         // -> flecha já rebentou todos que poderia
        continue;                         // -> passa todos os passos seguintes à frente
                                          // para verificar se o j já atingiu o seu limite
      }
      if (v[i] == 0 && i<v.length-2) {    // -> se o balão i já foi rebentado
        i++;                              // -> passo para o balão seguinte
        j = i+1;                          // -> j passa ao balão seguinte a i
        k = i+1;                          // -> k = posição seguinte ao i, para voltar quando terminar
                                          // a trajetória da flecha
      }
      if (v[i]-1 == v[j] && v[j] != 0) {  // -> se a altura do balão i for maior 1 unidade do que a
                                          // altura do balão j, então a flecha pode rebentar o j
        v[i] = 0;                         // -> i foi rebentado
        terminator++;                     // -> +1 rebentado
        if (k >= i && i<v.length) k = i+1;  // k for a posição após i, então só poderá ser a seguinte
        i = j;
        j = i+1;
      } else {
        j++;
      }
    }
    return arrows;
  }

  public static void main(String[] args) {
    FastScanner in = new FastScanner(System.in);

    int n = in.nextInt();               // número de balões
    int v[] = new int[n];               // guardar alturas
    for (int i=0 ; i<n ; i++) v[i] = in.nextInt();
    FastPrint.out.println(solve(v));
    FastPrint.out.close();
  }

}
