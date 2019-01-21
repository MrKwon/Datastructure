package michael.dsalgo.Chapter09;

public class Node<E> implements Position<E>{
    private E element;
    private Node<E> next;
    private Node<E> prev;

    public Node(E element, Node<E> prev, Node<E> next) {
        this.element = element;
        this.next = next;
        this.prev = prev;
    }

    @Override
    public E element() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getPrev() {
        return prev;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }
}
