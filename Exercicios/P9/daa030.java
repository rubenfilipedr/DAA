import java.util.*;
import java.io.*;


class Node {
  public LinkedList<Integer> adj;
  public boolean visited;
  public int distance;

  Node() {
    adj = new LinkedList<Integer>();
  }
}


class Graph {
  public int n;
  public Node nodes[];
  public int minDist[][];
  public int excen[];

  Graph(int n) {
    this.n = n;
    nodes = new Node[n+1];
    for (int i=1 ; i<=n ; i++) nodes[i] = new Node();
    minDist = new int[n+1][n+1];
    excen = new int[n+1];
  }

  public void addLink(int a, int b) {
    nodes[a].adj.add(b);
    nodes[b].adj.add(a);
  }

  public void bfs(int v) {
    LinkedList<Integer> q = new LinkedList<Integer>();
    for (int i=1 ; i<=n ; i++) nodes[i].visited = false;

    q.add(v);
    nodes[v].visited = true;
    nodes[v].distance = 0;

    while (q.size() > 0) {
      int u = q.removeFirst();
      for (int w : nodes[u].adj) {
        if (!nodes[w].visited) {
          q.add(w);
          nodes[w].visited = true;
          nodes[w].distance = nodes[u].distance + 1;
          minDist[v][w] = nodes[w].distance;
          if (minDist[v][w] > excen[w]) excen[w] = minDist[v][w];
        }
      }
    }
  }
}


public class daa030 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();             // nº de nós
    Graph g = new Graph(n);
    int e = in.nextInt();             // nº de arestas
    for (int i=0 ; i<e ; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      g.addLink(a, b);
    }
    for (int i=1 ; i<=n ; i++) g.bfs(i);

    int excen[] = new int[n+1];
    int diam = 0;
    int rad = 100000;

    for (int i=1 ; i<=n ; i++) {
      if (g.excen[i] > diam) diam = g.excen[i];
      if (g.excen[i] < rad) rad = g.excen[i];
    }
    System.out.println(diam);
    System.out.println(rad);

    int c = 0;
    int p = 0;
    int CentNodes[] = new int[n+1];
    int PeriNodes[] = new int[n+1];
    for (int i=1 ; i<=n ; i++) {
      if (g.excen[i] == rad) CentNodes[c++] = i;
      if (g.excen[i] == diam) PeriNodes[p++] = i;
    }

    for (int i=0 ; i<c ; i++) {
      System.out.print(CentNodes[i]);
      if (i<c-1) System.out.print(" ");
    }
    System.out.println();

    for (int i=0 ; i<p ; i++) {
      System.out.print(PeriNodes[i]);
      if (i<p-1) System.out.print(" ");
    }
    System.out.println();
  }

}
