package michael.dsalgo.Chapter05.ArrayStack;

import michael.dsalgo.Chapter05.Execptions.*;

public class ArrayStack<E> implements Stack<E> {
    public static final int CAPACITY = 1000;
    private int capacity;
    private E S[];
    private int top = -1;

    public ArrayStack() {
        this(CAPACITY);
    }

    public ArrayStack(int cap) {
        capacity = cap;
        S = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return (this.top + 1);
    }

    @Override
    public boolean isEmpty() {
        return (this.top < -1);
    }

    @Override
    public void push(E element) throws FullStackExecption {
        if (size() == capacity) return;

        S[++top]= element;
    }

    @Override
    public E top() throws EmptyStackExecption {
        if (isEmpty())
            throw new EmptyStackExecption("Stack is Empty");
        return S[top];
    }

    @Override
    public E pop() throws EmptyStackExecption {
        E element;
        if (isEmpty())
            throw new EmptyStackExecption("Stack is Empty");
        element = S[top];
        S[top--] = null;
        return element;
    }

    @Override
    public String toString() {
        String s = "[";
        if (size() > 0) s+= S[0];
        if (size() > 1)
            for (int i = 1; i <= size() - 1; i++)
                s = s + ", " + S[i];

        return s + "]";
    }

    public void status(String op, Object element) {
        System.out.print("------> " + op);
        System.out.println(", returns " + element);
        System.out.print("result: size = " + size() + ", isEmpty = " + isEmpty());
        System.out.println(", stack: " + this);
    }

    public static void main(String[] args) {
        Object o;
        ArrayStack<Integer> A = new ArrayStack<>();
        A.status("new ArrayStack<Integer> A", null);
        A.push(7);
        A.status("A.push(7)", null);
        o = A.pop();
        A.status("A.pop()", o);
        A.push(9);
        A.status("A.push(9)", null);

        ArrayStack<String> B = new ArrayStack<>();
        B.status("new ArrayStack<String> B", null);
        B.push("Bob");
        B.status("B.push(\"Bob\")", null);
        B.push("Alice");
        B.status("B.push(\"Alice\")", null);
        o = B.pop();
        B.status("B.pop()", o);
        B.push("Eve");
        B.status("B.push(\"Eve\")", null);
    }
}
