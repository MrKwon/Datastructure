package com.doit.chapter04;

public class IntQueue {
    private int capacity; // 최대 용량
    private int front; // 첫번째 원소
    private int rear; // 마지막 원소
    private int num; // 총 원소 수
    private int[] que; // 큐 본체

    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() { }
    }

    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() { }
    }

    public IntQueue(int capacity) {
        this.num = this.front = this.rear = 0;
        this.capacity = capacity;
        try {
            que = new int[this.capacity];
        } catch (OutOfMemoryError e) {
            this.capacity = 0;
        }
    }

    public int enque(int x) throws OverflowIntQueueException {
        if (this.num >= this.capacity)
            throw new OverflowIntQueueException();
        this.que[this.rear++] = x; //que[rear]에 원소를 추가하고 rear += 1
        this.num++;
        if (this.rear == this.capacity)
            // rear의 index가 맨 마지막에서 1 더해지면 capacity == rear가 됨, 이 때 0으로 가야함 (링 버퍼)
            rear = 0;
        return x;
    }

    public int deque() throws EmptyIntQueueException {
        if (this.num <= 0)
            throw new EmptyIntQueueException();
        int x = this.que[this.front++];
        this.num--;
        if (this.front == this.capacity)
            front = 0;
        return x;
    }

    public int peek() throws EmptyIntQueueException {
        if (this.num <= 0)
            throw new EmptyIntQueueException();
        return this.que[this.front];
    }

    public int indexOf(int x) {
        for (int i = 0; i < this.num; i++) {
            int index = (i + front) % capacity;
            if (que[index] == x)
                return index;
        }
        return -1;
    }

    public void clear() {
        this.num = this.front = this.rear = 0;
    }

    public int capacity() {
        return this.capacity;
    }

    public int size() {
        return this.num;
    }

    public int search(int x) {
        for (int i = 0; i < this.num; i++) {
            int index = (i + front) % capacity;
            if (que[index] == x)
                return index - (front - 1);
        }
        return 0;
    }

    public boolean isEmpty() {
        return this.num <= 0;
    }

    public boolean isFull() {
        return this.num >= this.capacity;
    }

    public void dump() {
        if (this.num <= 0)
            System.out.println("Queue is Empty");
        else {
            for (int i = 0; i < num; i++)
                System.out.print(que[(i + front) % capacity] + " ");
            System.out.println();
        }
    }
}
