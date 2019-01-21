package michael.dsalgo.Chapter06.PositionList;

import michael.dsalgo.Chapter06.PositionList.PositionException.*;

import java.util.Iterator;

/**
 * implementation of DoublyLinkedList
 * @author  KwonMC
 * @see     Node
 * @see     Position
 * @see     PositionList
 * @see     PositionException
 */
public class NodePositionList<E> implements PositionList<E> {
    private int size;
    private Node<E> first;
    private Node<E> last;

    /**
     * default constructor
     * Singly Linked List don't have capacity
     */
    public NodePositionList() {
        this.first = new Node<>(null, null, null);
        this.last = new Node<>(first, null, null);
        size = 0;
        this.first.setNext(this.last);
    }

    private Node<E> checkPosition(Position<E> p) throws InvalidPositionException {
        if (p == null)
            throw new InvalidPositionException("Null position passed to DoublyLinkedList");
        if (p == first)
            throw new InvalidPositionException("first is not invalid position");
        if (p == last)
            throw new InvalidPositionException("last is not invalid position");;

        try {
            Node<E> tmp = (Node<E>) p;
            if ((tmp.getPrev() == null) || (tmp.getNext() == null))
                throw new InvalidPositionException("Position does net belong to a valid DoublyLinkedList");
            return tmp;
        } catch (ClassCastException e) {
            throw new InvalidPositionException
                    ("Position is of wrong type for this list");
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    @Override
    public Position<E> first() throws EmptyListException {
        if (isEmpty()) throw new EmptyListException("List is empty");
        return this.first.getNext();
    }

    @Override
    public Position<E> last() throws EmptyListException {
        if (isEmpty()) throw new EmptyListException("List is empty");
        return this.last.getPrev();
    }

    @Override
    public Position<E> next(Position p) throws InvalidPositionException, BoundaryViolentException {
        Node<E> v = checkPosition(p);
        Node<E> next = v.getNext();
        if (next == this.last)
            throw new BoundaryViolentException
                    ("Cannot move back to the end of the list");
        return next;
    }

    @Override
    public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolentException {
        Node<E> v = checkPosition(p);
        Node<E> prev = v.getPrev();
        if (prev == this.first)
            throw new BoundaryViolentException
                    ("Cannot advance past the beginning of the list");

        return prev;
    }

    @Override
    public void addFirst(E e) {
        size++;
        Node<E> node = new Node<>(this.first, this.first.getNext(), e);
        first.getNext().setPrev(node);
        first.setNext(node);
    }

    @Override
    public void addLast(E e) {
        size++;
        Node<E> node = new Node<>(this.last.getPrev(), this.last, e);
        last.getPrev().setNext(node);
        last.setPrev(node);
    }

    @Override
    public void addAfter(Position<E> p, E e) throws InvalidPositionException {
        Node<E> v = checkPosition(p);
        size++;
        Node<E> node = new Node<>(v, v.getNext(), e);
        v.getNext().setPrev(node);
        v.setNext(node);
    }

    @Override
    public void addBefore(Position<E> p, E e) throws InvalidPositionException {
        Node<E> v = checkPosition(p);
        size++;
        Node<E> node = new Node<>(v.getPrev(), v, e);
        v.getPrev().setNext(node);
        v.setPrev(node);
    }

    @Override
    public E remove(Position<E> p) throws InvalidPositionException {
        Node<E> v = checkPosition(p);
        size--;

        Node<E> vPrev = v.getPrev();
        Node<E> vNext = v.getNext();

        vPrev.setNext(vNext);
        vNext.setPrev(vPrev);

        E vEle = v.element();

        v.setPrev(null);
        v.setNext(null);

        return vEle;
    }

    @Override
    public E set(Position<E> p, E e) throws InvalidPositionException {
        Node<E> v = checkPosition(p);
        E vOriginal = v.element();
        v.setElement(e);

        return vOriginal;
    }

    @Override
    public Iterator<E> iterator() {
        return new ElementIterator<>(this);
    }

    @Override
    public Iterable<Position<E>> positions() {
        PositionList<Position<E>> P = new NodePositionList<Position<E>>();

        if (!isEmpty()) {
            Position<E> p = first();
            while (true) {
                P.addLast(p);
                if (p == last())
                    break;
                p = next(p);
            }
        }
        return P;
    }
}
