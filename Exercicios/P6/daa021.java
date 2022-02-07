import java.util.*;


class daa021 {



  public static void main(String[] args) {
      FastScanner in = new FastScanner(System.in);
      TreeMap<Integer, Integer> m = new TreeMap<Integer, Integer>();
      int a = in.nextInt();             // quantidade de adições de bakugans
      int r = in.nextInt();             // quantidade de remoções de Min/Max

      for (int i=0 ; i<(a+r) ; i++) {
        String s = in.nextLine();
        if (s.equals("MAX")) {
          Map.Entry<Integer, Integer> highEntry = m.lastEntry();
          FastPrint.out.println(highEntry.getKey());
          if (highEntry.getValue() == 1) m.remove(highEntry.getKey());
          else m.put(highEntry.getKey(), highEntry.getValue()-1);
        }
        else if (s.equals("MIN")) {
          Map.Entry<Integer, Integer> lowEntry = m.firstEntry();
          FastPrint.out.println(lowEntry.getKey());
          if (lowEntry.getValue() == 1) m.remove(lowEntry.getKey());
          else m.put(lowEntry.getKey(), lowEntry.getValue()-1);
        }
        else {
          String[] bak = s.split(" ");
          int energy = Integer.parseInt(bak[1]);
          if (m.containsKey(energy)) m.put(energy, m.get(energy)+1);
          else m.put(energy, 1);
        }
      }
      FastPrint.out.close();
  }


}
