package michael.dsalgo.Chapter07.BinaryTree;

import michael.dsalgo.Chapter07.TreeExceptions.*;

public class Node<E> implements Position<E> {
    private E element;
    private Node<E> prev, next;

    public Node(Node<E> prev, Node<E> next, E element) {
        this.prev = prev;
        this.next = next;
        this.element = element;
    }

    @Override
    public E element() throws InvalidPositionException {
        if ((next == null) && (prev == null))
            throw new InvalidPositionException("Position is not in a list!");
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
