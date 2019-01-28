package dapd.Undirected;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class WeightedGraph {

    private static int NOPATH = -1;

    public class Node {
        int v;
        int weight;

        public Node(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        public int getV() {
            return v;
        }

        public int getWeight() {
            return weight;
        }

        public void setV(int v) {
            this.v = v;
        }
    }

    public int V; // vertex 수
    public LinkedList<Node> adj[];

    public WeightedGraph(int V) {
        this.V = V;
        this.adj = new LinkedList[this.V];
        for (int i = 0; i < this.V; ++i)
            this.adj[i] = new LinkedList<>();
    }

    public void addEdge(int u, int v, int weight) {
        Node tmp = new Node(v, weight);
        this.adj[u].add(tmp);
        tmp.setV(u);
        this.adj[v].add(tmp);
    }

    public void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack) {
        visited[v] = true;

        Iterator<Node> it = this.adj[v].listIterator();
        while (it.hasNext()) {
            Node tmp = it.next();
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
            dist[i] = -1; // -1 mean path is not exist
        dist[s] = 0;

        while (!stack.isEmpty()) {
            int u = stack.peek();
            stack.pop();

            Iterator<Node> it = this.adj[s].listIterator();

            if (dist[u] != -1) {
                while (it.hasNext()) {
                    Node tmp = it.next();
                    if (dist[tmp.getV()] < dist[u] + tmp.getWeight())
                        dist[tmp.getV()] = dist[u] + tmp.getWeight();
                }
            }
        }

        for (int i = 0; i < this.V; i++)
            if (dist[i] == -1)
                System.out.print("X ");
            else
                System.out.print(dist[i] + " ");
    }
}
