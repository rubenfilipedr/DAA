import java.util.*;

public class daa027 {
  static int n;           // nº de nós
  static boolean adj[][];
  static boolean visited[];
  static int color[];     // (-1 ou 1)

  static boolean dfs(int v) {
    int newColor;
    if (color[v] == -1) newColor = 1;
    else newColor = -1;

    visited[v] = true;
    for (int i=1 ; i<=n ; i++) {
      if (adj[v][i]) {
        if (visited[i]) {
          if (color[v] == color[i]) return false;
        }
        if (!visited[i]) {
          color[i] = newColor;
          if (!dfs(i)) return false;
        }
      }
    }
    return true;
  }

  static void reset(int n) {
    for (int i=0 ; i<=n ; i++) {
      visited[i] = false;
      color[i] = 0;
      for (int j=0 ; j<=n ; j++) {
        adj[i][j] = false;
      }
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int cases = in.nextInt();

    for (int i=0 ; i<cases ; i++) {
      n = in.nextInt();
      int e = in.nextInt();
      adj = new boolean[n+1][n+1];
      visited = new boolean[n+1];
      color = new int[n+1];

      for (int j=1 ; j<=e ; j++) {
        int a = in.nextInt();
        int b = in.nextInt();
        adj[a][b] = true;
        adj[b][a] = true;
      }

      color[1] = -1;
      if (dfs(1)) System.out.println("sim");
      else System.out.println("nao");
      reset(n);
    }
  }

}
