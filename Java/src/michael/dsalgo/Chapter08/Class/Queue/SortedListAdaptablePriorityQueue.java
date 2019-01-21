package michael.dsalgo.Chapter08.Class.Queue;

import michael.dsalgo.Chapter08.Exceptions.PQExceptions.*;
import michael.dsalgo.Chapter08.Exceptions.EntryExceptions.*;
import michael.dsalgo.Chapter08.Interface.Queue.AdaptablePriorityQueue;
import michael.dsalgo.Chapter08.Interface.Data.Entry;
import michael.dsalgo.Chapter08.Interface.Data.Position;

import java.util.Comparator;

public class SortedListAdaptablePriorityQueue<K, V>
        extends SortedListPriorityQueue<K, V>
        implements AdaptablePriorityQueue<K, V> {

    public SortedListAdaptablePriorityQueue() {
        super(); // extands 로 받아온 클래스
    }

    public SortedListAdaptablePriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    @Override
    public Entry<K, V> insert(K k, V v) throws InvalidKeyException {
        checkKey(k);
        LocationAwareEntry<K, V> entry = new LocationAwareEntry<>(k, v);
        insertEntry(entry);
        entry.setLocation(actionPos);
        return entry;
    }

    @Override
    public Entry<K, V> remove(Entry<K, V> entry) {
        checkEntry(entry);
        LocationAwareEntry<K, V> e = (LocationAwareEntry<K, V>) entry;
        Position<Entry<K, V>> p = e.location();
        entries.remove(p);
        e.setLocation(null);
        return e;
    }

    @Override
    public K replaceKey(Entry<K, V> entry, K key) {
        checkKey(key);
        checkEntry(entry);
        LocationAwareEntry<K, V> e = (LocationAwareEntry<K, V>) entry;
        K oldKey = e.setKey(key);
        insertEntry(e);
        e.setLocation(actionPos);
        return oldKey;
    }

    @Override
    public V replaceValue(Entry<K, V> entry, V value) {
        checkEntry(entry);
        V oldValue = ((LocationAwareEntry<K, V>) entry).setValue(value);
        return oldValue;
    }

    protected void checkEntry(Entry entry) throws InvalidEntryException {
        if (entry == null || !(entry instanceof LocationAwareEntry))
            throw new InvalidEntryException("invalid entry");
    }

    protected static class LocationAwareEntry<K, V>
            extends MyEntry<K, V>
            implements Entry<K, V> {
        private Position<Entry<K, V>> location;

        public LocationAwareEntry(K key, V value) {
            super(key, value);
        }

        public LocationAwareEntry(K key, V value, Position<Entry<K, V>> location) {
            super(key, value);
            this.location = location;
        }

        protected Position<Entry<K, V>> location() {
            return location;
        }

        protected Position<Entry<K, V>> setLocation(Position<Entry<K, V>> location) {
            Position<Entry<K, V>> oldPos = location();
            this.location = location;
            return oldPos;
        }

        protected K setKey(K newKey) {
            K oldKey = getKey();
            k = newKey;
            return oldKey;
        }

        protected V setValue(V newValue) {
            V oldValue = getValue();
            v = newValue;
            return oldValue;
        }
    }
}
