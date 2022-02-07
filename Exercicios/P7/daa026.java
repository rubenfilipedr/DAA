import java.util.*;

public class daa026 {
  static int rows;
  static int cols;
  static char m[][];
  static boolean visited[][];

  static int dfs(int y, int x) {
    int count = 0;
    if (y<0 || y>=rows || x<0 || x>=cols) return 0;
    if (visited[y][x]) return 0;
    if (m[y][x]!='#') return 0;
    visited[y][x] = true;
    count++;
    count += dfs(y-1,x);
    count += dfs(y+1,x);
    count += dfs(y,x-1);
    count += dfs(y,x+1);
    count += dfs(y-1,x-1);
    count += dfs(y-1,x+1);
    count += dfs(y+1,x-1);
    count += dfs(y+1,x+1);
    return count;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();       // número de casos
    for (int k=0 ; k<n ; k++) {
      rows = in.nextInt();   // número de linhas
      cols = in.nextInt();   // número de colunas
      m = new char[rows][cols];
      visited = new boolean[rows][cols];
      for (int i=0 ; i<rows ; i++) {
        m[i] = in.next().toCharArray();
      }

      int bigger = 0;
      for (int i=0 ; i<rows ; i++) {
        for (int j=0 ; j<cols ; j++) {
          if (m[i][j]=='#' && !visited[i][j]) {
            int cur = dfs(i, j);
            if (cur > bigger) bigger = cur;
          }
        }
      }
      System.out.println(bigger);
    }
  }

}
