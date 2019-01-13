package michael.dsalgo.Chapter05.Queue;

import michael.dsalgo.Chapter05.Execptions.*;
import michael.dsalgo.Chapter05.LinkedListStack.Node;

public class NodeQueue<E> implements Queue<E> {
    private static int CAPACITY = 1000;
    private Node<E> head;
    private Node<E> tail;
    private int capacity;
    private int size;

    public NodeQueue() {
        this(CAPACITY);
        head = tail = null;
    }

    public NodeQueue(int cap) {
        this.capacity = cap;
        head = tail = null;
    }

    @Override
    public int size() {
        if ((head == null) && (tail == null))
            return 0;

        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public E front() throws EmptyQueueExecption {
        return head.getElement();
    }

    @Override
    public void enqueue(E element) {
        Node<E> tmp = new Node<>();
        tmp.setElement(element);
        tmp.setNext(null);
        if (size() == 0)
            head = tmp;
        else
            tail.setNext(tmp);
        tail = tmp;
        size++;
    }

    @Override
    public E dequeue() throws EmptyQueueExecption {
        if (isEmpty()) throw new EmptyQueueExecption("Queue is Empty");

        E tmp = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0)
            tail = null;
        return tmp;
    }
}
