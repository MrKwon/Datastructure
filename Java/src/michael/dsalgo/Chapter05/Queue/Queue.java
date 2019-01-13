package michael.dsalgo.Chapter05.Queue;

import michael.dsalgo.Chapter05.Execptions.*;

public interface Queue<E> {
    public int size();
    public boolean isEmpty();
    public E front() throws EmptyQueueExecption;
    public void enqueue(E element);
    public E dequeue() throws EmptyQueueExecption;
}
