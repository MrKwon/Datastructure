package com.doit.chapter09;

import java.util.Comparator;

public class LinkedList<E> {
    class Node<E> {
        private E data;
        private Node<E> next;

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head; // Head
    private Node<E> crnt; // 선택한 노드

    public LinkedList() {
        this.head = this.crnt = null;
    }

    // comparator c 를 기준으로 obj 찾기
    public E search(E obj, Comparator<? super E> c) {
        Node<E> ptr = this.head;

        while (ptr != null) {
            if (c.compare(obj, ptr.data) == 0) {
                this.crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next;
        }
        return null;
    }

    // obj 를 머리 노드 위치에 삽입하기
    public void addFirst(E obj) {
        Node<E> ptr = this.head;
        this.head = this.crnt = new Node<>(obj, ptr);
    }

    // obj 를 꼬리 노드에 삽입
    public void addLast(E obj) {
        if (this.head == null)
            addFirst(obj);
        else {
            Node<E> ptr = this.head;
            while (ptr.next != null)
                ptr = ptr.next;
            ptr.next = crnt = new Node<>(obj, ptr);
        }
    }

    public void removeFirst() {
        this.head = this.crnt = this.head.next;
    }

    public void removeLast() {
        if (this.head != null) {
            if (this.head.next == null)
                removeFirst();
            else {
                Node<E> ptr = this.head;
                Node<E> pre = this.head;

                while (ptr.next != null) {
                    pre = ptr;
                    ptr = ptr.next;
                }
                pre.next = null;
                this.crnt = ptr;
            }
        }
    }

    public void remove(Node p) {
        if (this.head != null) {
            if (p == this.head)
                removeFirst();
            else {
                Node<E> ptr = this.head;

                while (ptr.next != p) {
                    ptr = ptr.next;
                    if (ptr == null) return;
                }
                ptr.next = p.next;
                this.crnt = ptr;
            }
        }
    }

    public void removeCurrentNode() {
        remove(this.crnt);
    }

    public void clear() {
        while (this.head != null)
            removeFirst();
        this.crnt = null;
    }

    public boolean next() {
        if (this.crnt == null || this.crnt.next == null)
            return false;
        this.crnt = this.crnt.next;
        return true;
    }

    public void printCurrentNode() {
        if (this.crnt == null)
            System.out.println("없음");
        else
            System.out.println(this.crnt.data);
    }

    public void dump() {
        Node<E> ptr = this.head;

        while (ptr != null) {
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }
}
