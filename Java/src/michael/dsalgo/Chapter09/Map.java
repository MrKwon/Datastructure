package michael.dsalgo.Chapter09;

import java.util.Iterator;

public interface Map<K, V> {
    public int size();
    public boolean isEmpty();
    public Entry<K, V> get(K key);
    public V put(K key, V value);
    public V remove(K key);
    public Iterator<K> keys();
    public Iterator<V> values();
    public Iterator<Entry<K, V>> entries();
}
