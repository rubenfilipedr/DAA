import java.util.*;

public class daa029 {
  static int n;                     // letras
  static boolean adj[][];           // matriz de adjacências
  static boolean visited[];         // array com posições visitadas
  static int order[];               // ordenação topológica
  static int norder;
  static boolean letters[];         // array com as letras (true se existe) (26 posições)

  static void dfs(int v) {
    visited[v] = true;
    for (int i=0; i<n; i++)
      if (adj[v][i] && !visited[i]) dfs(i);
    order[norder] = v;
    norder++;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int words = in.nextInt();                 // nº de palavras a ler
    n = 26;
    letters = new boolean[n];                // array com 26 posições (= 26 letras)
    adj = new boolean[n][n];
    visited = new boolean[n];
    order = new int[n];
    String p[] = new String[words];           // array com as palavras
    for (int i=0 ; i<words ; i++) {
      p[i] = in.next();
    }


    int j;                                    // palavra seguinte
    int minorSize;                            // tamanho da menor palavra entre a atual e a seguinte
    for (int i=0 ; i<words-1 ; i++) {
      j = i+1;
      if (p[i].length() <= p[j].length()) minorSize = p[i].length();
      else minorSize = p[j].length();
      for (int x=0 ; x<minorSize ; x++) {
        if (p[i].charAt(x) != p[j].charAt(x)) {
          adj[p[i].charAt(x)-'A'][p[j].charAt(x)-'A'] = true;;
          letters[p[i].charAt(x)-'A'] = true;
          letters[p[j].charAt(x)-'A'] = true;
          break;
        }
      }
    }


    norder = 0;
    for (int i=0 ; i<n ; i++) {
      if (letters[i] && !visited[i]) {
        dfs(i);
      }
    }

    for (int i=norder-1 ; i>=0 ; i--) {
      char c = (char)(order[i]+'A');
      System.out.print(c);
    }
    System.out.println();


  }

}
