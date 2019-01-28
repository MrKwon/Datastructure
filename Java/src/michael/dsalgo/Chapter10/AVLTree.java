package michael.dsalgo.Chapter10;

import michael.dsalgo.Chapter10.BinaryTree.Class.BTNode;
import michael.dsalgo.Chapter10.BinaryTree.Class.LinkedBinaryTree;
import michael.dsalgo.Chapter10.BinaryTree.Interface.BTPosition;
import michael.dsalgo.Chapter10.BinaryTree.Interface.BinaryTree;
import michael.dsalgo.Chapter10.BinaryTree.Interface.Position;
import michael.dsalgo.Chapter10.Exceptions.EntryExceptions.*;
import michael.dsalgo.Chapter10.Exceptions.TreeExceptions.*;

import java.util.Comparator;

public class AVLTree<K, V>
        extends BinarySearchTree<K, V>
        implements Dictionary<K, V> {

    public AVLTree() {
        super();
    }

    public AVLTree(Comparator<K> c) {
        super(c);
    }

    protected static class AVLNode<K, V> extends BTNode<Entry<K, V>> {
        protected int height;
        AVLNode(Entry<K, V> element, BTPosition<Entry<K, V>> parent,
                BTPosition<Entry<K, V>> left, BTPosition<Entry<K, V>> right) {
            super(element, parent, left, right);
            this.height = 0;
            if (left != null)
                this.height = Math.max(height, 1 + ((AVLNode<K, V>) left).getHeight());
            if (right != null)
                this.height = Math.max(height, 1 + ((AVLNode<K, V>) right).getHeight());
        }

        public void setHeight(int height) { this.height = height; }
        public int getHeight() { return this.height; }
    }

    protected BTPosition<Entry<K, V>> createNode(Entry<K, V> element,
                                                 BTPosition<Entry<K, V>> parent,
                                                 BTPosition<Entry<K, V>> left,
                                                 BTPosition<Entry<K, V>> right) {
        return new AVLNode<>(element, parent, left, right);
    }

    protected int height(Position<Entry<K, V>> pos) {
        return ((AVLNode<K, V>) pos).getHeight();
    }

    protected void setHeight(Position<Entry<K, V>> pos) {
        ((AVLNode<K, V>) pos).setHeight(1 + Math.max(height(left(pos)), height(right(pos))));
    }

    protected boolean isBalanced(Position<Entry<K, V>> pos ){
        int bf = height(left(pos)) - height(right(pos));
        return ((-1 <= bf) && (bf <= 1));
    }

    protected Position<Entry<K, V>> tallerChild(Position<Entry<K, V>> pos) {
        if (height(left(pos)) > height(right(pos))) return left(pos);
        else if (height(left(pos)) < height(right(pos))) return right(pos);

        if (isRoot(pos)) return left(pos);
        if (pos == parent(left(pos))) return left(pos);
        else return right(pos);
    }

    protected void rebalance(Position<Entry<K, V>> zPos) {
        if (isInternal(zPos))
            setHeight(zPos);

        while (!isRoot(zPos)) {
            zPos = parent(zPos); // bottom-up to root
            setHeight(zPos);
            if (!isBalanced(zPos)) {
                Position<Entry<K, V>> xPos = tallerChild(tallerChild(zPos)); // x는 z의 손자 중 큰 거
                zPos = restructure(xPos);
                setHeight(left(zPos));
                setHeight(right(zPos));
                setHeight(zPos);
            }
        }
    }

    public Entry<K, V> insert(K key, V value) throws InvalidKeyException {
        Entry<K, V> toReturn = super.insert(key, value);
        rebalance(actionPos);
        return toReturn;
    }

    public Entry<K, V> remove(Entry<K, V> entry) throws InvalidEntryException {
        Entry<K, V> toReturn = super.remove(entry);
        if (toReturn != null)
            rebalance(actionPos);
        return toReturn;
    }

    private Position<Entry<K, V>> restructure(Position<Entry<K, V>> x) {
        Position<Entry<K, V>> a, b, c;
        Position<Entry<K, V>> T0, T1, T2, T3; // subtree의 root 들

        // x는 맨 아래에 위치한 자식
        // 맨 아래에 위치한 노드(x)가 부모노드(parent(x))의 왼쪽에 있고
        // 그 부모노드가 x의 grandparent 노드(parent(parent(x))의 왼쪽에 있으면 순서대로 a, b, c

        // x = x
        // y = parent(x)
        // z = parent(parent(x))
        if (x == left(parent(x)) && parent(x) == left(parent(parent(x)))) {
            // p 434 그림 (b)
            a = x;
            b = parent(a);
            c = parent(b);

            T0 = left(a);
            T1 = right(a);
            T2 = right(b);
            T3 = right(c);
        } else if (x == right(parent(x)) && parent(x) == right(parent(parent(x)))) {
            // p 434 그림 (a)
            c = x;
            b = parent(c);
            a = parent(b);

            T0 = left(a);
            T1 = left(b);
            T2 = left(c);
            T3 = right(c);
        } else if (x == left(parent(x)) && parent(x) == right(parent(parent(x)))) {
            // p434 그림 (c)
            b = x;
            c = parent(b);
            a = parent(c);

            T0 = left(a);
            T1 = left(b);
            T2 = right(b);
            T3 = right(c);
        } else { // x == right(parent(x)) && parent(x) == left(parent(parent(x)))
            // p434 그림 (d)
            b = x;
            a = parent(b);
            c = parent(a);

            T0 = left(a);
            T1 = left(b);
            T2 = right(b);
            T3 = right(c);
        }

        ((BTPosition<Entry<K, V>>) a).setLeft((BTPosition<Entry<K, V>>) T0);
        ((BTPosition<Entry<K, V>>) a).setRight((BTPosition<Entry<K, V>>) T1);

        ((BTPosition<Entry<K, V>>) b).setLeft((BTPosition<Entry<K, V>>) a);
        ((BTPosition<Entry<K, V>>) b).setRight((BTPosition<Entry<K, V>>) c);

        ((BTPosition<Entry<K, V>>) c).setLeft((BTPosition<Entry<K, V>>) T2);
        ((BTPosition<Entry<K, V>>) c).setRight((BTPosition<Entry<K, V>>) T3);

        return b;
    }
}
