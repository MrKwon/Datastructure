package michael.dsalgo.Chapter08.Class.Queue;

import michael.dsalgo.Chapter08.Class.DefaultComparator;
import michael.dsalgo.Chapter08.Class.List.NodePositionList;
import michael.dsalgo.Chapter08.Exceptions.PQExceptions;
import michael.dsalgo.Chapter08.Exceptions.PQExceptions.*;
import michael.dsalgo.Chapter08.Interface.Data.Entry;
import michael.dsalgo.Chapter08.Interface.Data.Position;
import michael.dsalgo.Chapter08.Interface.List.PositionList;
import michael.dsalgo.Chapter08.Interface.Queue.PriorityQueue;

import java.util.Comparator;

public class SortedListPriorityQueue<K, V> implements PriorityQueue<K, V> {
    protected PositionList<Entry<K, V>> entries;
    protected Comparator<K> c;
    protected Position<Entry<K, V>> actionPos;

    protected static class MyEntry<K, V> implements Entry<K, V> {
        protected K k;
        protected V v;

        public MyEntry(K k, V v) {
            this.k = k;
            this.v = v;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }
    }

    public SortedListPriorityQueue() {
        entries = new NodePositionList<>();
        c = new DefaultComparator<K>();
    }

    public SortedListPriorityQueue(Comparator<K> c) {
        entries = new NodePositionList<>();
        this.c = c;
    }

    @Override
    public int size() {
        return entries.size();
    }

    @Override
    public boolean isEmpty() {
        return entries.isEmpty();
    }

    @Override
    public Entry<K, V> min() throws PQExceptions.EmptyPriorityQueueException {
        if (isEmpty())
            throw new EmptyPriorityQueueException("Priority queue is empty");
        else
            return entries.first().element();
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws PQExceptions.InvalidKeyException {
        checkKey(key);
        Entry<K, V> entry = new MyEntry<>(key, value);
        insertEntry(entry);
        return entry;
    }

    protected void insertEntry(Entry<K, V> e) {
        if (isEmpty()) {
            entries.addFirst(e);
            actionPos = entries.first();
        }
        else if (c.compare(e.getKey(), entries.last().element().getKey()) > 0) {
            entries.addLast(e);
            actionPos = entries.last();
        }
        else {
            Position<Entry<K, V>> curr = entries.first();
            while (c.compare(e.getKey(), curr.element().getKey()) > 0) {
                curr = entries.next(curr);
            }
            entries.addBefore(curr, e);
            actionPos = entries.prev(curr);
        }
    }

    @Override
    public Entry<K, V> removeMin() throws PQExceptions.EmptyPriorityQueueException {
        if (isEmpty())
            throw new EmptyPriorityQueueException("priority queue is empty");
        else
            return entries.remove(entries.first());
    }

    protected Entry<K, V> checkKey(K key) {
        Entry<K, V> tmp = new MyEntry<>(key, null);
        if (isEmpty()) return tmp;

        try {
            c.compare(key, entries.first().element().getKey());
        } catch (ClassCastException e) {
            throw new InvalidKeyException("is not valid key");
        }

        return tmp;
    }
}
