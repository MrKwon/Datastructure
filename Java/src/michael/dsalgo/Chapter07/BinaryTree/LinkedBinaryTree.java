package michael.dsalgo.Chapter07.BinaryTree;

import michael.dsalgo.Chapter07.TreeExceptions.*;

import java.util.Iterator;

public class LinkedBinaryTree<E> implements BinaryTree<E> {
    private BTPosition<E> root; // reference to root
    private int size;

    /**
     * Constructor
     */
    public LinkedBinaryTree() {
        root = null;
        size = 0;
    }

    /*
     Basic Tree Methods - implementation of BinaryTree interface
      */
    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isInternal(Position<E> v) throws InvalidPositionException {
        checkPosition(v);
        return (hasLeft(v) || hasRight(v));
    }

    @Override
    public boolean isExternal(Position<E> v) throws InvalidPositionException {
        checkPosition(v);
        return (!hasLeft(v) && !hasRight(v));
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    @Override
    public boolean isRoot(Position<E> v) throws InvalidPositionException {
        checkPosition(v);
        return (v == root());
    }

    @Override
    public boolean hasLeft(Position<E> v) {
        BTPosition<E> vv = checkPosition(v);
        return (vv.getLeft() != null);
    }

    @Override
    public boolean hasRight(Position<E> v) {
        BTPosition<E> vv = checkPosition(v);
        return (vv.getRight() != null);
    }

    @Override
    public Position<E> root() throws EmptyTreeException {
        if (root == null)
            throw new EmptyTreeException("The tree is Empty");
        return root;
    }

    @Override
    public Position<E> left(Position<E> v) throws InvalidPositionException, BoundaryViolationException {
        BTPosition vv = checkPosition(v);
        Position<E> leftPos = vv.getLeft();
        if (leftPos == null)
            throw new BoundaryViolationException("No left child");
        return leftPos;
    }

    @Override
    public Position<E> right(Position<E> v) throws InvalidPositionException, BoundaryViolationException {
        BTPosition vv = checkPosition(v);
        Position<E> rightPos = vv.getRight();
        if (rightPos == null)
            throw new BoundaryViolationException("No right child");
        return rightPos;
    }

    @Override
    public Position<E> parent(Position<E> v) throws InvalidPositionException, BoundaryViolationException {
        BTPosition<E> vv = checkPosition(v);
        Position<E> parentPos = vv.getParent();
        if (parentPos == null)
            throw new BoundaryViolationException("No parent");
        return parentPos;
    }

    @Override
    public Iterable<Position<E>> children(Position<E> v) throws InvalidPositionException {
        PositionList<Position<E>> children = new NodePositionList<>();
        if (hasLeft(v))
            children.addLast(left(v));
        if (hasRight(v))
            children.addLast(right(v));
        return children;
    }

    @Override
    public Iterable<Position<E>> positions() {
        PositionList<Position<E>> positions = new NodePositionList<>();
        if (size != 0)
            preorderPositions(root(), positions);
        return positions;
    }

    @Override
    public Iterator<E> iterator() {
        Iterable<Position<E>> positions = positions();
        PositionList<E> elements = new NodePositionList<>();
        for (Position<E> pos : positions)
            elements.addLast(pos.element());
        return elements.iterator();
    }

    @Override
    public E replace(Position<E> v, E e) throws InvalidPositionException {
        BTPosition<E> vv = checkPosition(v);
        E tmp = v.element();
        vv.setElement(e);
        return tmp;
    }

    /*
    Additional Accessor Method
     */
    public Position<E> sibling(Position<E> v)
            throws InvalidPositionException, BoundaryViolationException {
        BTPosition<E> vv = checkPosition(v);
        BTPosition<E> parentPos = vv.getParent();
        if (parentPos != null) {
            BTPosition<E> sibPos;
            BTPosition<E> leftPos = parentPos.getParent();

            if (leftPos == vv)
                sibPos = parentPos.getRight();
            else
                sibPos = parentPos.getLeft();

            if (sibPos != null)
                return sibPos;
        }
        throw new BoundaryViolationException("No Siblings");
    }

    /*
    Additional Update Methods
     */
    public Position<E> addRoot(E e) throws NonEmptyTreeException {
        if(!isEmpty())
            throw new NonEmptyTreeException("Tree already has a root");
        size = 1;
        root = createNode(e, null, null, null);
        return root;
    }

    public Position<E> insertLeft(Position<E> v, E e) throws InvalidPositionException {
        BTPosition<E> vv = checkPosition(v);
        Position<E> leftPos = vv.getLeft();
        if (leftPos != null)
            throw new InvalidPositionException("Node already has a left child");
        BTPosition<E> ww = createNode(e, vv, null, null);
        vv.setLeft(ww);
        size++;
        return ww;
    }

    public Position<E> insertRight(Position<E> v, E e) throws InvalidPositionException {
        BTPosition<E> vv = checkPosition(v);
        Position<E> rightPos = vv.getRight();
        if (rightPos != null)
            throw new InvalidPositionException("Node already has a right child");
        BTPosition<E> ww = createNode(e, vv, null, null);
        size++;
        return ww;
    }

    public E remove(Position<E> v) throws InvalidPositionException {
        BTPosition<E> vv = checkPosition(v);
        BTPosition<E> leftPos = vv.getLeft();
        BTPosition<E> rightPos = vv.getRight();
        if (leftPos != null && rightPos != null) // null 을 자식이 있는지 판단하기 위해 씀
            throw new InvalidPositionException("Cannot remove node with two children");

        BTPosition<E> ww;
        if (leftPos != null)
            ww = leftPos;
        else if (rightPos != null)
            ww = rightPos;
        else // child가 0개
            ww = null;

        if (vv == root) {
            if (ww != null)
                ww.setParent(null);
            root = ww;

        } else {
            BTPosition<E> uu = vv.getParent();
            if (vv == uu.getLeft())
                uu.setLeft(ww);
            else
                uu.setRight(ww);
            if (ww != null)
                ww.setParent(uu);
        }
        size--;
        return v.element();
    }

    public void attach(Position<E> v, BinaryTree<E> T1, BinaryTree<E> T2) throws InvalidPositionException {
        BTPosition<E> vv = checkPosition(v);
        if (isInternal(v))
            throw new InvalidPositionException("Cannot attatch from internal node");

        if (!T1.isEmpty()) {
            BTPosition<E> r1 = checkPosition(T1.root());
            vv.setLeft(r1);
            r1.setParent(vv);
        }

        if (!T2.isEmpty()) {
            BTPosition<E> r2 = checkPosition(T2.root());
            vv.setRight(r2);
            r2.setParent(vv);
        }
    }

    /*
    Auxiliary Methods
    */
    /**
     * Auxiliary helper method for position validation
     * @param v is to check position validation
     * @return v type conversed Position<E> to BTPosition<E>
     * @throws InvalidPositionException if v is null of v is not a instance of BTPosition
     */
    private BTPosition<E> checkPosition(Position<E> v) throws InvalidPositionException {
        if (v == null || !(v instanceof BTPosition))
            throw new InvalidPositionException("The position is invalid");
        return (BTPosition<E>) v;
    }

    private BTPosition<E> createNode(E element, BTPosition<E> parent,
                                     BTPosition<E> left, BTPosition<E> right) {
        return new BTNode<>(element, parent, left, right);
    }

    private void preorderPositions(Position<E> v, PositionList<Position<E>> pos) throws InvalidPositionException {
        pos.addLast(v);
        if (hasLeft(v))
            preorderPositions(left(v), pos);
        if (hasRight(v))
            preorderPositions(right(v), pos);
    }
}
