package michael.dsalgo.Chapter08.Interface.Data;

import java.math.BigDecimal;

/**
 * Interface for a key-value pair entry
 * @param <K> generic type for Key
 * @param <V> generic type for Value
 */
public interface Entry<K, V> {
    /**
     * @return the key sorted in this entry
     */
    public K getKey();

    /**
     * @return the value sorted in this entry
     */
    public V getValue();
}
