import java.util.*;

public class daa025 {
  static int n;
  static boolean adj[][];
  static boolean visited[];

  static void dfs(int v) {
    visited[v] = true;
    for (int i=1; i<=n; i++)
      if (adj[v][i] && !visited[i]) dfs(i);
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    n = in.nextInt();       // número de pontos de contacto
    int l = in.nextInt();   // número de ligações
    adj = new boolean[n+1][n+1];
    visited = new boolean[n+1];

    for (int i=0 ; i<l ; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      adj[a][b] = adj[b][a] = true;
    }

    int count = 0;
    for (int i=1 ; i<=n ; i++) {
      if (!visited[i]) {
        dfs(i);
        count++;
      }
    }
    System.out.println(count);
  }

}
