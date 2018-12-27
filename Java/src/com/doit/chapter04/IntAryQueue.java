package com.doit.chapter04;

public class IntAryQueue {
    private int capacity; // 큐 용량
    private int num; // 현재 데이터 수
    private int[] que; // 큐 본체

    public class EmptyIntQueException extends RuntimeException {
        public EmptyIntQueException() { }
    }

    public class QueOverflowException extends RuntimeException {
        public QueOverflowException() { }
    }

    public IntAryQueue(int capacity) {
        this.num = 0;
        this.capacity = capacity;
        try {
            que = new int[this.capacity];
        } catch (QueOverflowException e) {
            this.capacity = 0;
        }
    }

    public int enque(int x) throws QueOverflowException {
        if (this.num >= this.capacity)
            throw new QueOverflowException();
        return this.que[++num] = x;
    }

    public int deque() throws EmptyIntQueException {
        if (this.num <= 0)
            throw new EmptyIntQueException();
        int tmp = this.que[0];
        for (int i = 1; i < num - 1; i++)
            this.que[i - 1] = this.que[i]; // 비용이 너무 많이 든다. O(n)
        num--;
        return tmp;
    }
}
