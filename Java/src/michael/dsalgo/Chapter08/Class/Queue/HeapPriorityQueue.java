package michael.dsalgo.Chapter08.Class.Queue;

import java.util.Comparator;

import michael.dsalgo.Chapter08.Class.Tree.ArrayListCompleteBinaryTree;
import michael.dsalgo.Chapter08.Class.DefaultComparator;
import michael.dsalgo.Chapter08.Exceptions.PQExceptions.*;
import michael.dsalgo.Chapter08.Interface.Tree.CompleteBinaryTree;
import michael.dsalgo.Chapter08.Interface.Data.Entry;
import michael.dsalgo.Chapter08.Interface.Data.Position;
import michael.dsalgo.Chapter08.Interface.Queue.PriorityQueue;

public class HeapPriorityQueue<K, V> implements PriorityQueue<K, V> {
    protected CompleteBinaryTree<Entry<K, V>> heap;
    protected Comparator<K> comp;

    protected static class MyEntry<K, V> implements Entry<K, V> {
        protected K key;
        protected V value;

        public MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return null;
        }

        @Override
        public V getValue() {
            return null;
        }

        @Override
        public String toString() {
            return "(" + key + ", " + value + ")";
        }
    }

    public HeapPriorityQueue() {
        heap = new ArrayListCompleteBinaryTree<>();
        comp = new DefaultComparator<>();
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public boolean isEmpty() {
        return (heap.size() == 0);
    }

    @Override
    public Entry<K, V> min() throws EmptyPriorityQueueException {
        if (isEmpty())
            throw new EmptyPriorityQueueException("Priority queue is empty");
        return heap.root().element();
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws InvalidKeyException {

        return null;
    }

    @Override
    public Entry<K, V> removeMin() throws EmptyPriorityQueueException {
        return null;
    }

    private void checkKey(K key) throws InvalidKeyException {
        try {
            comp.compare(key, key);
        }
        catch (Exception e) {
            throw new InvalidKeyException("Invalid Key");
        }
    }

    private void upHeap(Position<Entry<K, V>> v) {
        Position<Entry<K, V>> u;
        while (!heap.isRoot(v)) {
            u = heap.parent(v);
            if (comp.compare(u.element().getKey(), v.element().getKey()) <= 0) break;
            swap(u, v);
            v = u;
        }
    }

    private void downHeap(Position<Entry<K, V>> r) {
        while (heap.isInternal(r)) {
            // r 이 external 이면 맨 아래에 있는거임, 그러니까 internal 한 동안 계속 아래로 내려보냄
            Position<Entry<K, V>> s;
            if (!heap.hasRight(r)) // r 이 오른쪽 자식이 없으면
                s = heap.left(r);
            else if (comp.compare(heap.left(r).element().getKey(),
                                  heap.right(r).element().getKey()) <= 0)
                s = heap.left(r);
            else
                s = heap.right(r);

            if (comp.compare(s.element().getKey(), r.element().getKey()) < 0) { // 자식노드가 더 작으면
                swap(r, s);
                r = s;
            }
            else
                break;
        }
    }

    private void swap(Position<Entry<K, V>> x, Position<Entry<K, V>> y) {
        Entry<K, V> tmp = x.element();
        heap.replace(x, y.element());
        heap.replace(y, tmp);
    }
}
