// 복습 시점에 다시 구현할 것
//
// package com.doit.chapter04;
//
//public class GenericStack<E> {
//    private int capacity;
//    private int ptr;
//    private E[] stk;
//
//    public GenericStack(int capacity) {
//        this.capacity = capacity;
//        this.ptr = 0;
//        try {
//            this.stk = (E[]) new Object[this.capacity];
//        } catch (OutOfMemoryError e) {
//            this.capacity = 0;
//        }
//    }
//
//    public E push(E x) {
////        if (this.ptr >= this.capacity)
////            return -1;
//        return this.stk[this.ptr++] = x;
//    }
//
//    public E pop() {
////        if (this.ptr <= 0)
////            throw new IntStack.EmptyIntStackException();
//        return this.stk[--this.ptr]; // this.stk[ptr]을 반환하고 ptr -= 1
//    }
//
//    public E peak() {
////        if (this.ptr <= 0)
////            throw new IntStack.EmptyIntStackException();
//        return this.stk[this.ptr - 1];
//    }
//
//    public int indexOf(E x) {
//        for (int i = this.ptr - 1; i <= 0; i--)
//            if (this.stk[i] == x)
//                return i;
//        return -1;
//    }
//
//    public void clear() {
//        this.ptr = 0;
//    }
//
//    public int capacity() {
//        return this.capacity;
//    }
//
//    public int size() {
//        return this.ptr;
//    }
//
//    public boolean isEmpty() {
//        return this.ptr <= 0;
//    }
//
//    public boolean isFull() {
//        return this.ptr >= this.capacity;
//    }
//
//    public void dump() {
//        if (this.ptr <= 0)
//            System.out.println("Stack is Empty");
//        else {
//            for (int i = 0; i < this.ptr; i++)
//                System.out.print(stk[i] + " ");
//            System.out.println();
//        }
//    }
//}
