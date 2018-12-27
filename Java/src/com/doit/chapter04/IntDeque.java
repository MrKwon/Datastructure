package com.doit.chapter04;

public class IntDeque {
    int capacity; // 큐의 크기
    int front; // 큐의 맨 앞
    int rear; // 큐의 맨 뒤
    int num; // 큐에 저장된 원소
    int deque[]; // 디큐의 본체

    public class EmptyIntDequeException extends RuntimeException {
        public EmptyIntDequeException() { }
    }

    public class OverflowIntDequeException extends RuntimeException {
        public OverflowIntDequeException() { }
    }

    public IntDeque(int capacity) {
        this.front = this.rear = this.num = 0;
        this.capacity = capacity;
        try {
            deque = new int[this.capacity];
        } catch (OutOfMemoryError e) {
            this.capacity = 0;
        }
    }

    public int enque(int x) throws OverflowIntDequeException {
        if (this.num >= this.capacity)
            throw new OverflowIntDequeException();
        this.deque[this.rear++] = x;
        this.num++;
        if (this.rear == this.capacity)
            this.rear = 0;
        return x;
    }

    public int deque() throws EmptyIntDequeException {
        if (this.num <= 0)
            throw new EmptyIntDequeException();
        int x = this.deque[this.front++];
        this.num--;
        if (this.front == this.capacity)
            this.front = 0;
        return x;
    }

    public int reverseEnque(int x) throws OverflowIntDequeException {
        if (this.num >= this.capacity)
            throw new OverflowIntDequeException();
        if (this.front == 0) {
            this.front = this.capacity - 1;
            this.deque[this.front] = x;
        } else {
            this.deque[--this.front] = x;
        }
        this.num++;
        return x;
    }

    public int reverseDeque() throws EmptyIntDequeException {
        if (this.num <= 0)
            throw new EmptyIntDequeException();
        int x;
        if (this.rear == 0) {
            this.rear = this.capacity - 1;
            x = this.deque[this.front];
        } else {
            x = this.deque[--this.rear];
        }
        this.num--;
        return x;
    }

    public int size() {
        return this.num;
    }

    public int capacity() {
        return this.capacity;
    }

    public void dump() {
        if (this.num <= 0)
            System.out.println("Queue is Empty");
        else {
            for (int i = 0; i < num; i++)
                System.out.print(deque[(i + front) % capacity] + " ");
            System.out.println();
        }
    }
}
