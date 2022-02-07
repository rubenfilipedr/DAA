import java.util.*;

// Classe que representa uma aresta
class Edge {
  int to;     // No destino
  float weight; // Peso da aresta

  Edge(int t, float w) {
    to = t;
    weight = w;
  }
}

// Classe que representa um no
class Node {
  public LinkedList<Edge> adj; // Lista de adjacencias
  public boolean visited;      // No ja foi visitado?
  public float distance;         // Distancia ao no origem da pesquisa
  public int pred;

  Node() {
    adj = new LinkedList<>();
  }
};

// Classe que representa um no para ficar na fila de prioridade
class NodeQ implements Comparable<NodeQ> {
  public float cost;
  public int node;

  NodeQ(float c, int n) {
    cost = c;
    node = n;
  }

  @Override
  public int compareTo(NodeQ nq) {
    if (cost < nq.cost) return -1;
    if (cost > nq.cost) return +1;
    if (node < nq.node) return -1;
    if (node > nq.node) return +1;
    return 0;
  }
}

// Classe que representa um grafo
class Graph {
  int n;          // Numero de nos do grafo
  Node nodes[];   // Array para conter os nos

  Graph(int n) {
    this.n = n;
    nodes = new Node[n+1];  // +1 se os nos comecam em 1 ao inves de 0
    for (int i=1; i<=n; i++)
      nodes[i] = new Node();
  }

  void addLink(int a, int b, float c) {
    nodes[a].adj.add(new Edge(b, c));
  }

  // Algoritmo de Dijkstra
  void dijkstra(int s) {

    //Inicializar nos como nao visitados e com distancia infinita
    for (int i=1; i<=n; i++) {
      nodes[i].distance = Integer.MAX_VALUE;
      nodes[i].visited  = false;
    }

    // Inicializar "fila" com no origem
    nodes[s].distance = 0;
    nodes[s].pred = s;
    TreeSet<NodeQ> q = new TreeSet<>();
    q.add(new NodeQ(0, s)); // Criar um par (dist=0, no=s)

    // Ciclo principal do Dijkstra
    while (!q.isEmpty()) {

      // Retirar no com menor distancia (o "primeiro" do set, que e uma BST)
      NodeQ nq = q.pollFirst();
      int  u = nq.node;
      nodes[u].visited = true;
//      System.out.println(u + " [dist=" + nodes[u].distance + "]");
/*
      //Mostrar caminho
      LinkedList<Integer> l = new LinkedList<>();
      int tmp = u;
      while (tmp != s) {
        l.addFirst(tmp);
        tmp = nodes[tmp].pred;
      }
      l.addFirst(s);
      System.out.println(l.toString());
      System.out.println();
*/
      // Relaxar arestas do no retirado
      for (Edge e : nodes[u].adj) {
        int v = e.to;
        float cost = e.weight;
        if (!nodes[v].visited && nodes[u].distance + cost < nodes[v].distance) {
          q.remove(new NodeQ(nodes[v].distance, v)); // Apagar do set
          nodes[v].distance = nodes[u].distance + cost;
          q.add(new NodeQ(nodes[v].distance, v));    // Inserir com nova (e menor) distancia
          nodes[v].pred = u;
        }
      }
    }
  }



};


public class daa033 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();         // nº de locais diferentes;
    int e = in.nextInt();         // nº de estradas
    Graph g = new Graph(n);

    String origin = in.next();
    String destination = in.next();
    in.nextLine();

    Map<String,Integer> map = new TreeMap<String,Integer>();
    map.put(origin, 1);
    map.put(destination, n);

    int k = 2;
    for (int i=0 ; i<e ; i++) {
      String s = in.nextLine();
      String parts[] = s.split(" ");
//      System.out.println(parts[0] + " " + parts[1] + " " + parts[2]);
      String a = parts[0];
      String b = parts[1];
      float dist = Float.parseFloat(parts[2]);
      if (!map.containsKey(a)) {
        map.put(a, k);
        k++;
      }
      if (!map.containsKey(b)) {
        map.put(b, k);
        k++;
      }
      g.addLink(map.get(a), map.get(b), dist);
      g.addLink(map.get(b), map.get(a), dist);
    }

    g.dijkstra(map.get(origin));
    System.out.println(String.format("%.1f", g.nodes[map.get(destination)].distance));
  }

}
