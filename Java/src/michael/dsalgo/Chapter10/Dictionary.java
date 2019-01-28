package michael.dsalgo.Chapter10;

public interface Dictionary<K, V> {
    public Entry<K, V> find(K key);
    public Iterable<Entry<K,V>> findAll(K key);
    public Entry<K, V> insert(K key, V value);
    public Entry<K, V> remove(Entry<K, V> entry);
}
