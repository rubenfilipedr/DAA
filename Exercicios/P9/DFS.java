import java.util.Scanner;


public class DFS {
  static boolean adj[][];    // Matriz de adjacencias
  static boolean visited[];  // Que nos ja foram visitados?
  static int v;              // nº de nós

  static void dfs(int x) {   // x representa o nó atual
    System.out.print("(" + x + ")");
    visited[x] = true;       // Marcamos como visitado
    for (int i=1; i<=v; i++) {
      if (adj[x][i] && !visited[i]) // Para cada nó adjacente e não visitado,
        dfs(i);                     // fazemos o mesmo processo
    }
  }


  public static void main(String args[]) {
    Scanner stdin = new Scanner(System.in);
    int n = stdin.nextInt();                   // n -> nº de casos

    for ( int j=0; j<n; j++) {
      v = stdin.nextInt();                 // nº de nós (vertices)
      int e = stdin.nextInt();             // nº de arestas (ligações)
      adj = new boolean[v+1][v+1];
      visited = new boolean[v+1];

      for (int i=1; i<=e; i++) {          // para cada ligação tens dois nós
        int a = stdin.nextInt();          // nó a (liga a)
        int b = stdin.nextInt();          // nó b
        adj[a][b] = adj[b][a] = true;     // se estão ligados, são adjacentes
      }

      dfs(1);
    }

  }

}
