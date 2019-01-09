package michael.dsalgo.Chapter03.DoublyLinkedList;

public class DNode <E> {
    private E element;
    private DNode<E> next, prev;

    public DNode(E element, DNode<E> prev, DNode<E> next) {
        this.element = element;
        this.next = next;
        this.prev = prev;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public DNode<E> getNext() {
        return next;
    }

    public void setNext(DNode<E> next) {
        this.next = next;
    }

    public DNode<E> getPrev() {
        return prev;
    }

    public void setPrev(DNode<E> prev) {
        this.prev = prev;
    }

}
