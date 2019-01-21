package michael.dsalgo.Chapter08.Interface.Queue;

import michael.dsalgo.Chapter08.Interface.Data.Entry;

public interface AdaptablePriorityQueue<K, V> {
    public Entry<K, V> remove(Entry<K, V> entry);
    public K replaceKey(Entry<K, V> entry, K key);
    public V replaceValue(Entry<K, V> entry, V value);
}
