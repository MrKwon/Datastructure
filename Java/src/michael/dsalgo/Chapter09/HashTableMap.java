package michael.dsalgo.Chapter09;

import michael.dsalgo.Chapter09.Exceptions.EntryException.*;

import java.util.Random;

public class HashTableMap<K, V> implements Map<K, V> {
    public static class HashEntry<K, V> implements Entry<K, V> {
        protected K key;
        protected V value;
        public HashEntry(K key, V value) { this.key = key; this.value = value; }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        public V setValue(V value) {
            V old = this.value;
            this.value = value;
            return old;
        }

        @Override
        public boolean equals(Object obj) {
            HashEntry<K, V> ent;
            try { ent = (HashEntry<K, V>) obj; }
            catch (ClassCastException e) { return false; }
            return (ent.getKey() == key) && (ent.getValue() == value);
        }
    }

    protected Entry<K, V> AVAILABLE = new HashEntry<>(null, null);
    protected int size = 0;
    protected int prime, capacity;
    protected Entry<K, V>[] bucket;
    protected long scale, shift;

    public HashTableMap(int cap) { this(109345121, cap); }
    public HashTableMap(int p, int cap) {
        this.prime = p;
        this.capacity = cap;
        this.bucket = (Entry<K, V>[]) new Entry[capacity];
        Random rand = new Random();
        this.scale = rand.nextInt(this.prime - 1) + 1;
        this.shift = rand.nextInt(this.prime);
    }

    protected void checkKey(K key) {
        if (key == null) throw new InvalidKeyException("Invalid key : null");
    }

    public int hashValue(K key) {
        return (int) ((Math.abs(key.hashCode() * this.scale + this.shift) % this.prime) % this.capacity);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    @Override
    public Entry<K, V> get(K key) {
        Entry<K, V> result = new HashEntry<>(null, null);

        return result;
    }

    @Override
    public V put(K key, V value) {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public Iterable<K> keys() {
        return null;
    }

    @Override
    public Iterable<V> values() {
        return null;
    }

    @Override
    public Iterable<Entry<K, V>> entries() {
        return null;
    }
}
