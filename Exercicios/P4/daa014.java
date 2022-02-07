/*
Dado um conjunto de N encomendas de sapatos, cada um com a respectiva duração e
multa por dia, a tua tarefa é determinar qual a ordem em que o sapateiro deve
tratar das encomendas de modo a pagar a menor multa possível.
*/

import java.util.*;

class Shoe implements Comparable<Shoe> {
  public int type;
  public int duration;
  public int sanction;
  public float ratio;

  Shoe(int type, int duration, int sanction) {
    this.type = type;
    this.duration = duration;
    this.sanction = sanction;
    ratio = (float)sanction/duration;
  }

  public int compareTo(Shoe s) {
    if (ratio > s.ratio) return -1;
    if (ratio < s.ratio) return 1;
    if (type < s.type) return -1;
    if (type > s.type) return 1;
    return 0;
  }

  public String toString() {
    String s = "" + type;
    return s;
  }
}

class daa014 {

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();         // número de encomendas
    Shoe s[] = new Shoe[n];
    for (int i=0 ; i<n ; i++) {   // sapatos (tipo, duração, multa)
      s[i] = new Shoe(i+1, in.nextInt(), in.nextInt());
    }
    Arrays.sort(s);
    for (int i=0 ; i<n ; i++) {
      System.out.print(s[i]);
      if (i<n-1) System.out.print(" ");
    }
    System.out.println();
  }

}
