import java.util.*;
import java.io.*;


class Cell {
  public int x, y;                    // coordenadas (x,y)
  public LinkedList<Cell> adj;        // lista de células adjacentes
  public boolean visited;             // célula visitada?
  public int distance;                // distancia

  Cell(int x, int y) {
    this.x = x;
    this.y = y;
    adj = new LinkedList<Cell>();
  }
}


class Graph {
  public int n;                       // nº total de células
  public int rows, cols;              // nº de linhas e colunas
  public Cell cells[][];              // array para guardar todas as células

  Graph(int l, int c) {
    rows = l;                         // l linhas
    cols = c;                         // c colunas
    n = rows*cols;                    // total de células = linhas*colunas
    cells = new Cell[l][c];           // todas as células
    for (int i=0 ; i<rows ; i++) {
      for (int j=0 ; j<cols ; j++) {
        cells[i][j] = new Cell(i, j);
      }
    }
    addLink();
  }

  public void addLink() {
    for (int i=0 ; i<rows ; i++) {
      for (int j=0 ; j<cols ; j++) {
        if (i<rows-1) cells[i][j].adj.add(cells[i+1][j]);
        if (i>0) cells[i][j].adj.add(cells[i-1][j]);
        if (j<cols-1) cells[i][j].adj.add(cells[i][j+1]);
        if (j>0) cells[i][j].adj.add(cells[i][j-1]);
      }
    }
  }


  public void bfs(char m[][]) {
    LinkedList<Cell> q = new LinkedList<Cell>();
    for (int i=0 ; i<rows ; i++) {
      for (int j=0 ; j<cols ; j++) cells[i][j].visited = false;
    }

    for (int i=0 ; i<rows ; i++) {
      for (int j=0 ; j<cols ; j++) {
        if (m[i][j]=='#') {
          q.add(new Cell(i, j));
          cells[i][j].visited = true;
          cells[i][j].distance = 0;
        }
      }
    }

    while (q.size() > 0) {
      Cell u = q.removeFirst();
      for (Cell w : cells[u.x][u.y].adj) {
        if (!w.visited) {
          q.add(w);
          w.visited = true;
          w.distance = u.distance + 1;
        }
      }
    }
  }
}


public class daa031 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int l = in.nextInt();               // nº de linhas
    int c = in.nextInt();               // nº de colunas
    char m[][] = new char[l][c];
    for (int i=0 ; i<l ; i++) m[i] = in.next().toCharArray();
    Graph g = new Graph(l, c);
    g.bfs(m);

    int minN = 100000;
    int maxN = 0;
    for (int i=0 ; i<l ; i++) {
      for (int j=0 ; j<c ; j++) {
        if (m[i][j]=='A') {
          if (g.cells[i][j].distance < minN) minN = g.cells[i][j].distance;
          if (g.cells[i][j].distance > maxN) maxN = g.cells[i][j].distance;
        }
      }
    }
    System.out.println(minN + " " + maxN);
  }

}
