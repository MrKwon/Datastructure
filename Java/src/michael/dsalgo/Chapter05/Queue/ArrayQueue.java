package michael.dsalgo.Chapter05.Queue;

import michael.dsalgo.Chapter05.Execptions.*;

public class ArrayQueue<E> implements Queue<E> {
    public static int CAPACITY = 1000;

    private int front;
    private int end;
    private int capacity;
    private E arr[];

    public ArrayQueue() {
        this(CAPACITY);
        front = end = 0;
    }

    public ArrayQueue(int cap) {
        this.capacity = cap;
        arr = (E[]) new Object[this.capacity];
    }

    @Override
    public int size() { // queue를 가득 채우면 0이 된다. 왜지..
        return (this.capacity - front + end) % this.capacity;
    }

    @Override
    public boolean isEmpty() {
        return (front == end) && size() == 0;
    }

    @Override
    public E front() throws EmptyQueueExecption {
        if (isEmpty()) throw new EmptyQueueExecption("Queue is Empty");

        return arr[front];
    }

    @Override
    public void enqueue(E element) throws FullQueueExecption {
        if (size() == capacity) throw new FullQueueExecption("Queue is Full");

        arr[end] = element;
        end = (end + 1) % this.capacity;
    }

    @Override
    public E dequeue() throws EmptyQueueExecption {
        if (isEmpty()) throw new EmptyQueueExecption("Queue is Empty");

        E tmp = arr[front];
        arr[front] = null;
        front = (front + 1) % this.capacity;
        return tmp;
    }

    @Override
    public String toString() {
        String s = "";
        if (isEmpty()) {
            s += "[ ]";
            return s;
        }

        for (int i = 0; i < this.capacity; i++) {
            if (i == front) {
                s += " +";
            } else if (i == end) {
                s += " -";
            } else if (front == end) {
                s += " *";
            } else {
                s += "  ";
            }
        }

        s += "\n[";

        for (int i = 0; i < this.capacity; i++) {
            if (arr[i] == null)
                s += "  ";
            else
                if (i == 0)
                    s += arr[i];
                else
                    s += arr[i] + " ";
        }

        s+= "]\n";

        return s;
    }
}
