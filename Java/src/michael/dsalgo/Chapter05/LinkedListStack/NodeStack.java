package michael.dsalgo.Chapter05.LinkedListStack;

import michael.dsalgo.Chapter05.Execptions.*;

public class NodeStack<E> implements Stack<E> {
    private Node<E> top;
    private int size;

    public NodeStack() {
        top = null;
        size = 0;
    }

    @Override
    public int size() { return size; }

    @Override
    public boolean isEmpty() {
        if (top == null) return true;
        return false;
    }

    @Override
    public void push(E element) {
        Node<E> ptr = this.top;
        this.top = new Node<>(element, ptr);

        size++;
    }

    @Override
    public E top() throws EmptyStackExecption {
        if(isEmpty()) throw new EmptyStackExecption("Stack is empty");
        return top.getNext().getElement();
    }

    @Override
    public E pop() throws EmptyStackExecption {
        if(isEmpty()) throw new EmptyStackExecption("Stack is empty");
        Node<E> tmp = top;
        E ele = tmp.getElement();
        top = top.getNext();
        tmp.setNext(null);
        size--;
        return ele;
    }

    @Override
    public String toString() {
        String s;
        s = "size : " + size() + "\n";
        if (top == null) {
            s = "|empty|\n";
            s += "------\n";
            return s;
        }

        Node<E> tmpNode;
        tmpNode = top;
        while (tmpNode != null) {
            s += "|  " + tmpNode.getElement() + "  |\n";
            s += "|-----|\n";
            tmpNode = tmpNode.getNext();
        }

        return s;
    }
}
