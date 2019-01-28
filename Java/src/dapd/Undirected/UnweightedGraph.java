package dapd.Undirected;

import java.util.Iterator;
import java.util.LinkedList;

public class UnweightedGraph {
    private int V; // vertex 개수
    private LinkedList<Integer> adj[]; // 인접행렬

    public UnweightedGraph(int v) {
        this.V = v;
        this.adj = new LinkedList[this.V];
        for (int i = 0; i < this.V; ++i) {
            this.adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int u) {
        this.adj[v].add(u);
        this.adj[u].add(v);
    }

    void BFS(int s) {
        boolean[] visited = new boolean[this.V];

        LinkedList<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            s = queue.poll();
            System.out.print(s + " ");

            Iterator<Integer> it = this.adj[s].listIterator();
            while (it.hasNext()) {
                int n = it.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    void DFSutil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> it = this.adj[v].listIterator();
        while (it.hasNext()) {
            int n = it.next();
            if (!visited[n])
                DFSutil(n, visited);
        }
    }

    void DFS(int s) {
        boolean[] visited = new boolean[this.V];
        DFSutil(s, visited);
    }

    // Undirected Graph 에서는 Topological Sort 가 불가능하다.

    boolean cyclicUtil(int s, boolean visited[]) {
        int[] parent = new int[this.V];

        for (int i = 0; i < this.V; i++)
            parent[i] = -1;

        LinkedList<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.push(s);

        while (!queue.isEmpty()) {
            s = queue.poll(); // peek() and pop()
            System.out.print(s + " ");

            Iterator<Integer> it = this.adj[s].listIterator();
            while (it.hasNext()) {
                int n = it.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                    parent[n] = s;
                } else if (parent[s] != n)
                    return true;
            }
        }
        return false;
    }

    boolean isCyclic() {
        boolean[] visited = new boolean[this.V];

        for (int i = 0; i < this.V; i++)
            visited[i] = false;

        for (int i = 0; i < this.V; i++)
            if (!visited[i] && cyclicUtil(i, visited))
                return true;
        return false;
    }

    public static void main(String[] args) {
        UnweightedGraph graph = new UnweightedGraph(4);

        graph.addEdge(0, 1);
//        graph.addEdge(0, 2);
//        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);

        for (int i = 0; i < 4; i++) {
            System.out.println("\nstart vertex : " + i + "BFS");
            graph.BFS(i);
        }

        System.out.println();

        for (int i = 0; i < 4; i++) {
            System.out.println("\nstart vertex : " + i + "DFS");
            graph.DFS(i);
        }

        System.out.println();
        System.out.println("is Cyclic ? : " + graph.isCyclic());
    }
}
