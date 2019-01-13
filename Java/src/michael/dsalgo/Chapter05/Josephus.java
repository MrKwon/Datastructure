package michael.dsalgo.Chapter05;

import michael.dsalgo.Chapter05.Queue.NodeQueue;
import michael.dsalgo.Chapter05.Queue.Queue;

public class Josephus {
    public static <E> E Josephus(Queue<E> Q, int k) {
        if (Q.isEmpty()) return null;

        while (Q.size() > 1) {
            System.out.println("  Queue: " + Q + " k = " + k);
            for (int i = 0; i < k; i++)
                Q.enqueue(Q.dequeue());
            E e = Q.dequeue();
            System.out.println("    " + e + " is out");
        }
        return Q.dequeue();
    }

    public static <E> Queue<E> buildQueue(E a[]) {
        Queue<E> Q = new NodeQueue<>();
        for (int i = 0; i < a.length; i++)
            Q.enqueue(a[i]);
        return Q;
    }

    public static void main(String[] args) {
        String[] a = {"1", "2", "3", "4", "5", "6", "7"};

        System.out.println(Josephus(buildQueue(a), 3));
    }
}
