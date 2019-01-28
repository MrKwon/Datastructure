package dapd.Directed;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;


public class WeightedGraph {
    private static int NINF = -1;
    class AdjListNode {
        private int v;
        private int weight;

        public AdjListNode(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        public int getV() {
            return v;
        }

        public int getWeight() {
            return weight;
        }
    }

    private int V;
    private LinkedList<AdjListNode> adj[];

    public WeightedGraph(int V) {
        this.V = V;
        this.adj = new LinkedList[V];
        for (int i = 0; i < this.V; ++i) {// 0 is placeholder
            this.adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v, int weight) {
        AdjListNode tmp = new AdjListNode(v, weight);
        this.adj[u].add(tmp);
    }

    /**
     * Weighted Graph 가 Acyclic 한 경우에만 사용한다.
     */
    void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack) {
        visited[v] = true;

        Iterator<AdjListNode> it = this.adj[v].listIterator();
        while (it.hasNext()) {
            AdjListNode tmp = it.next();
            if (!visited[tmp.getV()])
                topologicalSortUtil(tmp.getV(), visited, stack);
        }

        stack.push(v);
    }

    void longestPath(int s) {
        Stack<Integer> stack = new Stack<>();
        int[] dist = new int[this.V];

        boolean[] visited = new boolean[this.V];
        for (int i = 0; i < this.V; i++)
            visited[i] = false;

        for (int i = 0; i < this.V; i++)
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);

        for (int i = 0; i < this.V; i++)
            dist[i] = NINF;
        dist[s] = 0;

        while (!stack.isEmpty()) {
            int u = stack.peek();
            stack.pop();

            Iterator<AdjListNode> it = this.adj[s].listIterator();
            if (dist[u] != -NINF) {
                while(it.hasNext()) {
                    AdjListNode i = it.next();
                    if (dist[i.getV()] < dist[u] + i.getWeight())
                        dist[i.getV()] = dist[u] + i.getWeight();
                }
            }
        }

        for (int i = 0; i < this.V; i++)
            if (dist[i] == NINF)
                System.out.print("INF ");
            else
                System.out.print(dist[i] + " ");
    }

    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph(5);

        graph.addEdge(0, 2, 2);
        graph.addEdge(1, 3, 4);
        graph.addEdge(2, 0, 2);
        graph.addEdge(2, 3, 3);
        graph.addEdge(3, 1, 4);
        graph.addEdge(3, 2, 3);
        graph.addEdge(3, 4, 6);
        graph.addEdge(4, 3, 6);

        for (int i = 0; i < 5; i++) {
            graph.longestPath(i);
            System.out.println();
        }
    }
}
