/*
Dadas as coordenadas de um quadrado e um círculo a tua tarefa é descobrir qual
a área da zona da interseção entre ambas as duas figuras geométricas.
*/


import java.util.Scanner;


class daa006 {

  public static float distance(float x1, float y1, float x2, float y2) {
    float distance = (float)Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
    return distance;
  }


  public static float intersection(float x1, float x2, float y1, float y2, int cx, int cy, int r) {

    // uma fora da outra
    if ( distance(x1,y1,cx,cy) >= r &&    // distancia do centro ao inf.esq. >= r
         distance(x1,y2,cx,cy) >= r &&    // distancia do centro ao sup.es. >= r
         distance(x2,y1,cx,cy) >= r &&    // distancia do centro ao inf.dir. >= r
         distance(x2,y2,cx,cy) >= r &&    // distancia do centro ao sup.dir. >= r
         (x1>=cx+r || x2<=cx-r || y1>=cy+r || y2<=cy-r) ) return 0;

    // quadrado dentro do circulo
    if ( distance(x1,y1,cx,cy) <= r &&
         distance(x1,y2,cx,cy) <= r &&
         distance(x2,y1,cx,cy) <= r &&
         distance(x2,y2,cx,cy) <= r ) return ((x2-x1)*(y2-y1));

    // circulo dentro do quadrado
    if ( cx-r>=x1 && cx+r<=x2 && cy-r>=y1 && cy+r<=y2 ) return (float)(r*r*Math.PI);

    float area = 0;
    float half = (x2-x1)/2;
    if ( (x2-x1)*(y2-y1) >= 0.00001 ) {
      area += intersection(x1, x2-half, y1+half, y2, cx, cy, r);  // sup. esq.
      area += intersection(x1+half, x2, y1+half, y2, cx, cy, r);  // sup. dir.
      area += intersection(x1, x2-half, y1, y2-half, cx, cy, r);  // inf. esq.
      area += intersection(x1+half, x2, y1, y2-half, cx, cy, r);  // inf. dir.
    }

    return area;
  }


  public static void main (String[] args) {

    FastScanner in = new FastScanner(System.in);

    int n = in.nextInt();   // nº de casos

    for (int i=0 ; i<n ; i++) {
      int qx = in.nextInt();    // abcissa canto inferior esquerdo
      int qy = in.nextInt();    // ordenada canto inferior esquerdo
      int ql = in.nextInt();    // lado do quadrado

      int cx = in.nextInt();    // abcissa do centro do circulo
      int cy = in.nextInt();    // ordenada do centro do circulo
      int cr = in.nextInt();    // raio do circulo

      FastPrint.out.println(intersection(qx, qx+ql, qy, qy+ql, cx, cy, cr));
    }
    FastPrint.out.close();

  }

}
