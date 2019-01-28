package michael.dsalgo.Chapter09;

import java.util.Iterator;

public class SimpleListMap<K, V> implements Map<K, V> {

    public static class MyEntry<K, V> implements Entry<K, V> {
        private K key;
        private V value;

        public MyEntry() {
            this.key = null;
            this.value = null;
        }

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

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private DoublyLinkedList<MyEntry<K, V>> list;
    private int size;

    public SimpleListMap() {
        this.list = new DoublyLinkedList<>();
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return (this.size() == 0);
    }

    @Override
    public Entry<K, V> get(K key) {
        Entry<K, V> result;

        for (MyEntry<K, V> tmp : this.list) {
            if (tmp.getKey() == key) {
                result = tmp;
                return result;
            }
        }

        return null;
    }

    @Override
    public V put(K key, V value) {
        for (MyEntry<K, V> tmp : this.list) {
            if (tmp.getKey() == key) {
                V tmpValue = tmp.getValue();
                tmp.setValue(value);
                size++;
                return tmpValue;
            }
        }

        return null;
    }

    @Override
    public V remove(K key) {
        for (MyEntry<K, V> tmp : this.list) {
            if (tmp.getKey() == key) {
                V tmpValue = tmp.getValue();
                list.remove((Position<MyEntry<K, V>>) tmp); // 확인해봐야댐
                size--;
                return tmpValue;
            }
        }
        return null;
    }

    @Override
    public Iterable<K> keys() {
        PositionList<K> keys = new DoublyLinkedList<>();
        for (MyEntry<K, V> tmp : this.list) {
            keys.addLast(tmp.getKey());
        }

        return keys;
    }

    @Override
    public Iterable<V> values() {
        PositionList<V> values = new DoublyLinkedList<>();
        for (MyEntry<K, V> tmp : this.list) {
            values.addLast(tmp.getValue());
        }

        return values;
    }

    @Override
    public Iterable<Entry<K, V>> entries() {
        PositionList<Entry<K, V>> entries = new DoublyLinkedList<>();
        for (MyEntry<K, V> tmp : this.list) {
            entries.addLast(tmp);
        }

        return entries;
    }
}
