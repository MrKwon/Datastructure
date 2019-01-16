package michael.dsalgo.Chapter05.Deque;

import michael.dsalgo.Chapter05.Deque.DequeException.*;

public interface Deque<E> {
    public int size();
    public boolean isEmpty();
    public E getFirst() throws EmptyDequeException;
    public E getLast() throws EmptyDequeException;
    public void addFirst(E element);
    public void addLast(E element);
    public E removeFirst() throws EmptyDequeException;
    public E removeLast() throws EmptyDequeException;
}
