package com.doit.chapter04;

public class IntStack {
    private int ptr;
    private int capacity;
    private int[] stk;

    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() { }
    }

    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() { }
    }

    public IntStack(int capacity) {
        this.ptr = 0;
        this.capacity = capacity;
        try {
            this.stk = new int[this.capacity];
        } catch (OutOfMemoryError e) {
            this.capacity = 0;
        }
    }

    public int push(int x) throws OverflowIntStackException {
        if (this.ptr >= this.capacity)
            throw new OverflowIntStackException();
        return this.stk[this.ptr++] = x;
    }

    public int pop() throws EmptyIntStackException {
        if (this.ptr <= 0)
            throw new EmptyIntStackException();
        return this.stk[--this.ptr]; // this.stk[ptr]을 반환하고 ptr -= 1
    }

    public int peak() throws EmptyIntStackException {
        if (this.ptr <= 0)
            throw new EmptyIntStackException();
        return this.stk[this.ptr - 1];
    }

    public int indexOf(int x) {
        for (int i = this.ptr - 1; i <= 0; i--)
            if (this.stk[i] == x)
                return i;
        return -1;
    }

    public void clear() {
        this.ptr = 0;
    }

    public int capacity() {
        return this.capacity;
    }

    public int size() {
        return this.ptr;
    }

    public boolean isEmpty() {
        return this.ptr <= 0;
    }

    public boolean isFull() {
        return this.ptr >= this.capacity;
    }

    public void dump() {
        if (this.ptr <= 0)
            System.out.println("Object is Empty");
        else {
            for (int i = 0; i < this.ptr; i++)
                System.out.print(stk[i] + " ");
            System.out.println();
        }
    }
}
