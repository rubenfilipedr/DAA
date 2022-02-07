/*
Dado um conjunto de N segmentos de recta com coordenadas [Li, Ri] e um número M,
a tua tarefa é descobrir qual a menor quantidade possível de segmentos que
cobrem o segmento [0,M].
*/

import java.util.*;


class Segment implements Comparable<Segment>{
  public int ini;
  public int end;
  public int total;

  Segment(int ini, int end) {
    this.ini = ini;
    this.end = end;
    total = end-ini;
  }

  public int compareTo(Segment seg) {
    if (ini < seg.ini) return -1;
    if (ini > seg.ini) return 1;
    if (total < seg.total) return 1;
    if (total > seg.total) return -1;
    return 0;
  }

  public String toString() {
    return ("(" + ini + "," + end + "," + total + ")");
  }
}


class daa013 {

  public static int solve(Segment s[], int m) {
    int i = 0;
    int count = 0;
    int end = 0;
    int bigEnd = 0;
    while (end < m ) {
      for ( ; s[i].ini<=end ; i++) {
        if (s[i].end > bigEnd) bigEnd = s[i].end;
        if (i == s.length-1) break;
      }
      end = bigEnd;
      count++;
    }
    return count;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int m = in.nextInt();         // tamanho do segmento que queremos cobrir
    int n = in.nextInt();         // quantidade de segmentos a considerar
    Segment s[] = new Segment[n];
    for (int i=0 ; i<n ; i++) {   // segmentos
      s[i] = new Segment(in.nextInt(), in.nextInt());
    }
    Arrays.sort(s);
    System.out.println(solve(s, m));
  }

}
