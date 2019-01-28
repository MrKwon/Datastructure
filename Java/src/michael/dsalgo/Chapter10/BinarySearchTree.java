package michael.dsalgo.Chapter10;

import michael.dsalgo.Chapter10.BinaryTree.Class.LinkedBinaryTree;
import michael.dsalgo.Chapter10.BinaryTree.Class.NodePositionList;
import michael.dsalgo.Chapter10.BinaryTree.Interface.Position;
import michael.dsalgo.Chapter10.BinaryTree.Interface.PositionList;
import michael.dsalgo.Chapter10.Exceptions.EntryExceptions.*;
import michael.dsalgo.Chapter10.Exceptions.TreeExceptions.*;

import java.util.Comparator;

public class BinarySearchTree<K, V>
        extends LinkedBinaryTree<Entry<K, V>>
        implements Dictionary<K, V> {

    protected Comparator<K> comparator;
    protected Position<Entry<K, V>> actionPos;
    protected int numEntries = 0;

    public BinarySearchTree() {
        this.comparator = new DefaultComparator<>();
        addRoot(null);
    }

    public BinarySearchTree(Comparator<K> c) {
        this.comparator = c;
        addRoot(null);
    }

    protected static class BSTEntry<K, V> implements Entry<K, V> {
        protected K key;
        protected V value;
        protected Position<Entry<K, V>> pos;
        BSTEntry() { }
        BSTEntry(K key, V value, Position<Entry<K, V>> p) {
            this.key = key;
            this.value = value;
            this.pos = p;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        public Position<Entry<K, V>> position() {
            return this.pos;
        }
    }

    protected K key(Position<Entry<K, V>> position) {
        return position.element().getKey();
    }

    protected V value(Position<Entry<K, V>> position) {
        return position.element().getValue();
    }

    protected Entry<K, V> entry(Position<Entry<K, V>> position) {
        return position.element();
    }

    protected void replaceEntry(Position<Entry<K, V>> pos, Entry<K, V> ent) {
        ((BSTEntry<K, V>) ent).pos = pos;
        replace(pos, ent);
    }

    protected void checkKey(K key) throws InvalidKeyException {
        if (key == null)
            throw new InvalidKeyException("key is null");
    }

    protected void checkEntry(Entry<K, V> entry) throws InvalidEntryException {
        if (entry == null || !(entry instanceof BSTEntry))
            throw new InvalidEntryException("invalid entry");
    }

    protected Entry<K, V> insertAtExternal(Position<Entry<K, V>> v, Entry<K, V> e) {
        expandExternal(v, null, null);
        replace(v, e);
        this.numEntries++;
        return e;
    }

    private void expandExternal(Position<Entry<K, V>> v, Entry<K, V> left, Entry<K, V> right) {
        if (isInternal(v))
            throw new NotExternalNodeException("this node is not a External Node");
        insertLeft(v, left);
        insertRight(v, right);
    }

    protected void removeExternal(Position<Entry<K, V>> v) {
        removeAboveExternal(v);
        this.numEntries--;
    }

    /**
     * external node 위의 node 로 해당 node 와 external node 인 자식 노드를 함께 삭제
     * childs 모두가 external node 면 둘 다 삭제 + 해당 노드 삭제
     * left child 만 external node 면 left child 와 해당 노드 삭제
     * right child 만 external node 면 right child 와 해당 노드 삭제
     * @param v 현재 node 의 position
     */
    private void removeAboveExternal(Position<Entry<K, V>> v) {
        if (hasRight(v) && hasLeft(v)) // 양쪽 child 가 있으면 external node 위가 아님
            throw new NotExternalNodeException("this position is not above External Node");


        Position<Entry<K, V>> rightChild = right(v);
        Position<Entry<K, V>> leftChild = left(v);

        if (hasLeft(v)) {
            // remove right and v
            remove(entry(rightChild));
        } else if (hasRight(v)) {
            // remove left and v
            remove(entry(leftChild));
        } else {
            remove(entry(leftChild));
            remove(entry(rightChild));
        }

        remove(entry(v));
    }

    protected Position<Entry<K, V>> treeSearch(K key, Position<Entry<K, V>> pos) {
        if (isExternal(pos)) return pos;
        else {
            K curKey = key(pos);
            int comp = comparator.compare(key, curKey);
            if (comp < 0)
                return treeSearch(key, left(pos));
            else if (comp > 0)
                return treeSearch(key, right(pos));
            return pos;
        }
    }

    protected void addAll(PositionList<Entry<K, V>> list, Position<Entry<K, V>> v, K k) {
        if (isExternal(v)) return;
        Position<Entry<K, V>> pos = treeSearch(k, v);
        if (!isExternal(pos)) {
            addAll(list, left(pos), k);
            list.addLast(pos.element());
            addAll(list, right(pos), k);
        }
    }

    @Override
    public int size() {
        return this.numEntries;
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    @Override
    public Entry<K, V> find(K key) throws InvalidKeyException {
        checkKey(key);
        Position<Entry<K, V>> curPos = treeSearch(key, root());
        this.actionPos = curPos;
        if (isInternal(curPos)) return entry(curPos);
        return null;
    }

    @Override
    public Iterable<Entry<K, V>> findAll(K key) throws InvalidKeyException {
        checkKey(key);
        PositionList<Entry<K, V>> list = new NodePositionList<>();
        addAll(list, root(), key);
        return list;
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws InvalidKeyException {
        checkKey(key);
        Position<Entry<K, V>> insPos = treeSearch(key, root());
        while (!isExternal(insPos))
            insPos = treeSearch(key, left(insPos));
        this.actionPos = insPos;
        return insertAtExternal(insPos, new BSTEntry<>(key, value, insPos));
    }

    @Override
    public Entry<K, V> remove(Entry<K, V> entry) {
        checkEntry(entry);
        Position<Entry<K, V>> remPos = ((BSTEntry<K, V>) entry).position();
        Entry<K, V> toReturn = entry(remPos);
        if (isExternal(left(remPos))) remPos = left(remPos);
        else if (isExternal(right(remPos))) remPos = right(remPos);
        else {
            Position<Entry<K, V>> swapPos = remPos;
            remPos = right(swapPos);
            do {
                remPos = left(remPos);
            } while (isInternal(remPos));
            replaceEntry(swapPos, (Entry<K, V>) parent(remPos).element());
        }
        this.actionPos = sibling(remPos);
        removeExternal(remPos);
        return toReturn;
    }
}
