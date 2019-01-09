package michael.dsalgo.Chapter03.BookEx;

import michael.dsalgo.Chapter03.DoublyLinkedList.DNode;

import java.util.Comparator;

/**
 * Don't have Main
 * @param <E> DList 의 DNode 에 들어가는 ele 의 자료형
 */
public class DList<E> {
    protected int size;
    protected DNode<E> header, trailer;

    public DList() {
        size = 0;
        header = new DNode<>(null, null, null);
        trailer = new DNode<>(null, header, null);
        header.setNext(trailer);
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public DNode getFirst() throws IllegalStateException {
        if (isEmpty()) throw new IllegalStateException("List is Empty");
        return header.getNext();
    }

    public DNode getLast() throws IllegalStateException {
        if (isEmpty()) throw new IllegalStateException("List is Empty");
        return trailer.getPrev();
    }

    public DNode getPrev(DNode v) throws IllegalArgumentException {
        if (v == header) throw new IllegalArgumentException
                ("Cannot move back past the header of the list");
        return v.getPrev();
    }

    public DNode getNext(DNode v) throws IllegalArgumentException {
        if (v == trailer) throw new IllegalArgumentException
                ("Cannot move forward past the trailer of the list");
        return v.getNext();
    }

    public void addBefore(DNode v, DNode z) throws IllegalArgumentException {
        DNode u = getPrev(v);
        z.setPrev(u);
        z.setNext(v);
        v.setPrev(z);
        u.setNext(z);
        size++;
    }

    public void addAfter(DNode v, DNode z) throws IllegalArgumentException {
        DNode w = getNext(v);
        z.setPrev(v);
        z.setNext(w);
        w.setPrev(z);
        v.setNext(z);
        size++;
    }

    public void addFirst(DNode v) {
        addAfter(header, v);
    }

    public void addLast(DNode v) {
        addBefore(trailer, v);
    }

    public void remove(DNode v) {
        DNode u = getPrev(v);
        DNode w = getNext(v);

        w.setPrev(u);
        u.setNext(w);
        v.setPrev(null);
        v.setNext(null);
        size--;
    }

    public boolean hasPrev(DNode v) { return v != header; }
    public boolean hasNext(DNode v) { return v != trailer; }


    @Override
    public String toString() {
        String s = "[";
        DNode<E> v = header.getNext();
        while (v != trailer) {
            s += v.getElement();
            v = v.getNext();
            if (v != trailer)
                s += " ";
        }
        s += "]";

        return s;
    }
}
