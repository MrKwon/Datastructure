package dapd.Directed;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class UnweightedGraph {
    // Adjacency List is used for representing graph
    private int V;
    private LinkedList<Integer> adj[];

    public UnweightedGraph(int v) {
        this.V = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            this.adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        this.adj[v].add(w);
    }

    void BFS(int s) {
        boolean[] visited = new boolean[this.V];

        LinkedList<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            s = queue.poll();
            System.out.print(s + " ");

            Iterator<Integer> i = this.adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
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

        Iterator<Integer> i = this.adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSutil(n, visited);
        }
    }

    void DFS(int s) {
        boolean[] visited = new boolean[this.V];
        DFSutil(s, visited);
    }

    void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack) {
        visited[v] = true;
        Integer i;

        Iterator<Integer> it = this.adj[v].iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }

        stack.push(v);
    }

    void topologicalSort() { // Cyclic Graph 는 사용이 불가능하다
        Stack<Integer> stack = new Stack<>();

        boolean[] visited = new boolean[this.V];
        for (int i = 0; i < this.V; i++)
            visited[i] = false;

        for (int i = 0; i < this.V; i++)
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);

        while (!stack.isEmpty())
            System.out.println(stack.pop() + " ");
    }

    boolean isCycle() {
        int[] degree = new int[this.V];

        for (int i = 0; i < this.V; i++) {
            degree[i] = 0;
        }

        for (int u = 0; u < this.V; u++) {
            Iterator<Integer> it = this.adj[u].listIterator();
            while (it.hasNext()) {
                int n = it.next();
                degree[n]++;
            }
        }

        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < this.V; i++)
            if (degree[i] == 0)
                queue.push(i);

        int cnt = 0;

        LinkedList<Integer> topOrder = new LinkedList<>();

        while(!queue.isEmpty()) {
            int u = queue.poll();
            topOrder.push(u);

            Iterator<Integer> it = this.adj[u].listIterator();
            while (it.hasNext()) {
                int n = it.next();
                if (--degree[n] == 0) {
                    queue.push(n);
                }
            }
            cnt++;
        }

        if (cnt != this.V)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        UnweightedGraph graph = new UnweightedGraph(4);

        graph.addEdge(0, 2);
        graph.addEdge(2, 1);
        graph.addEdge(1, 3);
//        graph.addEdge(3, 0);

//        for (int i = 0; i < 4; i++) {
//            System.out.printf("\ndirected graph start : %d BFS\n", i);
//            graph.BFS(i);
//        }
//
//        System.out.println();
//
//        for (int i = 0; i < 4; i++) {
//            System.out.printf("\ndirected graph start : %d DFS\n", i);
//            graph.DFS(i);
//        }
//
//        System.out.println();
//
//        System.out.println("is Cyclic ? : " + graph.isCycle());
//
////        graph.topologicalSort();
    }
}
