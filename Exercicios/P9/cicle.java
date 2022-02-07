import java.util.*;

public class cicle {
  static int n;
  static boolean adj[][];
  static int color[];     // (1 -> Branco, 2 -> Cinza ou 3 -> Preto)

  static void dfs(int v) {
    color[v] = 1;
    for (int i=1 ; i<=n ; i++) {
      if (adj[v][i]) {
        if (color[i] == 2) System.out.println("Ciclo encontrado! -> Aresta(" + v + "," + i + ")");
        else if (color[i] == 1) dfs(i);
      }
    }
    color[v] = 3;
  }


  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    n = in.nextInt();
    int e = in.nextInt();
    adj = new boolean[n+1][n+1];
    color = new int[n+1];
    for (int i=0 ; i<e ; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      adj[a][b] = true;
      adj[b][a] = true;
    }

    for (int i=1 ; i<=n ; i++) {
      color[i] = 1;
    }

    for (int i=1 ; i<=n ; i++) {
      if (color[i] == 1) dfs(i);
    }
  }

}
