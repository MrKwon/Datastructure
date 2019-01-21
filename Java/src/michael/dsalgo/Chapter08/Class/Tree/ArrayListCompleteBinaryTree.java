package michael.dsalgo.Chapter08.Class.Tree;

import michael.dsalgo.Chapter08.Exceptions.TreeExceptions.*;
import michael.dsalgo.Chapter08.Interface.Tree.CompleteBinaryTree;
import michael.dsalgo.Chapter08.Interface.Data.Position;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListCompleteBinaryTree<E> implements CompleteBinaryTree<E> {
    protected ArrayList<BTPos<E>> T;
    protected static class BTPos<E> implements Position<E> {
        E element;
        int index;

        public BTPos(E element, int i) {
            this.element = element;

        }

        @Override
        public E element() {
            return null;
        }

        public int index() { return index; }
        public E setElement(E element) {
            E tmp = element;
            this.element = element;
            return tmp;

        }
    }

    public ArrayListCompleteBinaryTree() {
        this.T = new ArrayList<>();
        T.add(0, null); // loc 0 은 비어있음
    }

    @Override
    public int size() {
        return this.T.size() - 1; // loc 0 은 비어있는데 이걸 빼줘야 함
    }

    @Override
    public boolean isEmpty() {
        return (this.size() == 0);
    }

    @Override
    public boolean isInternal(Position<E> v) throws InvalidPositionException {
        // child 가 하나라도 있으면 Internal Node 인데 complete binary tree의 rule 에 따라
        // child는 왼쪽부터 생김
        return hasLeft(v); // left child 가 없으면 무조건 External Node 임
    }

    @Override
    public boolean isExternal(Position<E> v) throws InvalidPositionException {
        return !isInternal(v);
    }

    @Override
    public boolean isRoot(Position<E> v) throws InvalidPositionException {
        return (checkPosition(v).index == 1);
    }

    @Override
    public boolean hasLeft(Position<E> v) {
        return (2 * checkPosition(v).index) <= size();
    }

    @Override
    public boolean hasRight(Position<E> v) {
        return (2 * checkPosition(v).index) + 1 <= size();
    }

    @Override
    public Position<E> root() throws EmptyTreeException {
        if (isEmpty()) throw new EmptyTreeException("Tree is empty");
        return T.get(1);
    }

    @Override
    public Position<E> left(Position<E> v) throws InvalidPositionException, BoundaryViolationException {
        if (!hasLeft(v))
            throw new BoundaryViolationException("No left child");

        return T.get(2 * checkPosition(v).index);
    }

    @Override
    public Position<E> right(Position<E> v) throws InvalidPositionException, BoundaryViolationException {
        if (!hasRight(v))
            throw new BoundaryViolationException("No right child");

        return T.get(2 * checkPosition(v).index + 1);
    }

    @Override
    public Position<E> parent(Position<E> v) throws InvalidPositionException, BoundaryViolationException {
        if (isRoot(v))
            throw new BoundaryViolationException("No parent");

        return T.get(checkPosition(v).index / 2);
    }

    @Override
    public E replace(Position<E> v, E e) throws InvalidPositionException {
        return checkPosition(v).setElement(e);
    }

    @Override
    public Position<E> add(E element) { // ArrayListCompleteBinaryTree 의 메서드 add
        int i = size() + 1;
        BTPos<E> p = new BTPos<>(element, i);
        T.add(i, p); // ArrayList 의 메서드 add
        return null;
    }

    @Override
    public E remove() throws EmptyTreeException {
        if (isEmpty())
            throw new EmptyTreeException("Tree is Empty");

        return T.remove(size()).element();
    }

    private BTPos<E> checkPosition(Position<E> v) throws InvalidPositionException {
        if (v == null || !(v instanceof BTPos))
            throw new InvalidPositionException("Position is invalid");
        return (BTPos<E>) v;
    }

    @Override
    public Iterator<E> iterator() {
        ArrayList<E> list = new ArrayList<>();
        Iterator<BTPos<E>> iter = T.iterator();
        iter.next();
        while (iter.hasNext())
            list.add(iter.next().element());
        return list.iterator();
    }

    @Override
    public Iterable<Position<E>> positions() {
        return null;
    }

    @Override
    public Iterable<Position<E>> children(Position<E> v) throws InvalidPositionException {
        return null;
    }
}
