package michael.dsalgo.Chapter09;

import michael.dsalgo.Chapter09.Exceptions.LinkedListExceptions.*;

import java.util.Iterator;

public class DoublyLinkedList<E> implements PositionList<E> {
    private int size;
    private Node<E> head;
    private Node<E> tail;

    public DoublyLinkedList() {
        this.head = new Node<>(null, null, null);
        this.tail = new Node<>(null, this.head, null);
        this.head.setNext(this.tail);
        this.size = 0;
    }

    protected Node<E> checkPosition(Position<E> p) {
        if (p == null)
            throw new InvalidPositionException("Null position passed to DoublyLinkedList");
        if (p == this.head)
            throw new InvalidPositionException("head is not invalid position");
        if (p == this.tail)
            throw new InvalidPositionException("tail is not invalid position");

        try {
            Node<E> tmp = (Node<E>) p;
            if (tmp.getNext() == null || tmp.getPrev() == null)
                throw new InvalidPositionException("Position is not belongs to DoublyLinkedList");
            return tmp;
        } catch (ClassCastException e) {
            throw new InvalidPositionException("Position is not a proper type to this list");
        }
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
    public Position<E> first() {
        if (isEmpty()) throw new EmptyLinkedListException("Linked List is empty");
        return this.head.getNext();
    }

    @Override
    public Position<E> last() {
        if (isEmpty()) throw new EmptyLinkedListException("Linked List is empty");
        return this.tail.getPrev();
    }

    @Override
    public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolentException {
        Node<E> tmp = checkPosition(p);
        Node<E> next = tmp.getNext();
        if (next == this.tail)
            throw new BoundaryViolentException("Position p is the tail of the list");
        return next;
    }

    @Override
    public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolentException {
        Node<E> tmp = checkPosition(p);
        Node<E> prev = tmp.getPrev();
        if (prev == this.head)
            throw new BoundaryViolentException("Position p is the head of the list");
        return prev;
    }

    @Override
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e, this.head, this.head.getNext());
        this.head.getNext().setPrev(newNode);
        this.head.setNext(newNode);
        this.size++;
    }

    @Override
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e, this.tail.getPrev(), this.tail);
        this.tail.getPrev().setNext(newNode);
        this.tail.setPrev(newNode);
        this.size++;
    }

    @Override
    public void addAfter(Position<E> p, E e) throws InvalidPositionException {
        Node<E> tmp = checkPosition(p);
        Node<E> newNode = new Node<>(e, tmp, tmp.getNext());
        tmp.getNext().setPrev(newNode);
        tmp.setNext(newNode);
        size++;
    }

    @Override
    public void addBefore(Position<E> p, E e) throws InvalidPositionException {
        Node<E> tmp = checkPosition(p);
        Node<E> newNode = new Node<>(e, tmp.getPrev(), tmp);
        tmp.getPrev().setNext(newNode);
        tmp.setPrev(newNode);
        size++;
    }

    @Override
    public E remove(Position<E> p) throws InvalidPositionException {
        Node<E> tmp = checkPosition(p);
        E e = tmp.element();
        tmp.getPrev().setNext(tmp.getNext());
        tmp.getNext().setPrev(tmp.getPrev());
        tmp.setPrev(null);
        tmp.setNext(null);
        size--;
        return e;
    }

    @Override
    public E set(Position<E> p, E e) throws InvalidPositionException {
        Node<E> tmp = checkPosition(p);
        E oldEle = tmp.element();
        tmp.setElement(e);
        return oldEle;
    }

    @Override
    public Iterator<E> iterator() {
        return new ElementIterator<>(this);
    }

    @Override
    public Iterable<Position<E>> positions() {
        PositionList<Position<E>> list = new DoublyLinkedList<>();

        if (!isEmpty()) {
            Position<E> ptr = this.first();
            while (true) {
                list.addLast(ptr);
                if (ptr == last()) break;
                ptr = this.next(ptr);
            }
        }
        return null;
    }
}
