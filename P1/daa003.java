import java.util.Scanner;

public class daa003 {

  public static int generation(String s) {   // descobre a geração
    int casesGeneration = 5290000;           // casos por geração nas 3 primeiras (23^2 * 10^4)
    if (Character.isLetter(s.charAt(0))) {
      if (Character.isLetter(s.charAt(7))) return casesGeneration*3;   // 4ª geração
      else return 0;                                        // 1ª geração
    } else {
      if (Character.isLetter(s.charAt(3))) return casesGeneration*2;   // 3ª geração
      else return casesGeneration;                          // 2ª geração
    }
  }

  public static int number(String s1) {
    int n = generation(s1);
    int base = 1;
    for (int i=7 ; i>=0 ; i--) {
      if (Character.isDigit(s1.charAt(i))) {
        n += (s1.charAt(i) - '0') * base;
        base *= 10;
      }
    }
    for (int i=7 ; i>=0 ; i--) {
      if (Character.isLetter(s1.charAt(i))) {
        int letterValue = s1.charAt(i) - 'A';
        if (s1.charAt(i) > 'K') letterValue--;
        if (s1.charAt(i) > 'W') letterValue--;
        if (s1.charAt(i) > 'Y') letterValue--;
        n += letterValue * base;
        base *= 23;
      }
    }
    return n;
  }

  public static void main (String[] args) {
    Scanner in = new Scanner(System.in);

    int t = in.nextInt();    // nº de testes
    for (int i=0 ; i<t ; i++) {
      String s1 = in.next();
      String s2 = in.next();
      System.out.println(Math.abs(number(s1) - number(s2)));
    }

  }

}
