package com.doit.chapter09;

import java.util.Comparator;

public class AryLinkedList<E> {
    class Node<E> {
        private E data;
        private int next;
        private int dnext;

        void set(E data, int next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E>[] n;    // 본체
    private int size;       // 리스트 용량 (가장 큰 데이터 수)
    private int max;        // 사용 중인 꼬리 record
    private int head;       // 머리 노드
    private int crnt;       // 선택 노드
    private int deleted;    // free 리스트의 머리 노드
    private static final int NULL = -1; // 다음 노드 없음 / 리스트가 가득참

    public AryLinkedList(int capacity) {
        this.head = this.crnt = this.max = this.deleted = NULL;

        try {
            this.n = new Node[capacity];
            for (int i = 0; i < capacity; i++)
                this.n[i] = new Node<E>();
            this.size = capacity;
        } catch (OutOfMemoryError e) {
            this.size = 0;
        }
    }

    // 다음에 삽입하는 record의 인덱스를 구함
    private int getInsertIndex () {
        if (this.deleted == NULL) {
            if (this.max < this.size)
                return ++this.max;
            else
                return NULL;
        } else {
            int rec = this.deleted;
            this.deleted = n[rec].dnext;
            return rec;
        }
    }

    // record index를 free 리스트에 등록
    private void deleteIndex(int index) {
        if (this.deleted == NULL) {
            this.deleted = index;
            n[index].dnext = NULL;
        } else {
            int rec = deleted;
            deleted = index;
            n[rec].dnext = rec;
        }
    }

    // 노드를 검색
    public E search(E obj, Comparator<? super E > c) {
        int ptr = head;

        while (ptr != NULL) {
            if (c.compare(obj, n[ptr].data) == 0) {
                crnt = ptr;
                return n[ptr].data;
            }
            ptr = n[ptr].next;
        }
        return null;
    }

    // 머리에 노드를 삽입
    public void addFirtst(E obj) {
        int ptr = head;
        int rec = getInsertIndex();
        if (rec != NULL) {
            head = crnt = rec;
            n[head].set(obj, ptr);
        }
    }

    // 꼬리에 노드를 삽입
    public void addLast(E obj) {
        if (head == NULL)
            addFirtst(obj);
        else {
            int ptr = head;
            while (n[ptr].next != NULL)
                ptr = n[ptr].next;
            int rec = getInsertIndex();
            if (rec != NULL) {
                n[ptr].next = crnt = rec;
                n[rec].set(obj, NULL);
            }
        }
    }

    // 머리 노드를 삭제
    public void removeFirst() {
        if (head != NULL) {
            int ptr = n[head].next;
            deleteIndex(head);
            head = crnt = ptr;
        }
    }

    // 꼬리 노드를 삭제
    public void removeLast() {
        if (head != NULL) {
            if (n[head].next == NULL)
                removeFirst();
            else {
                int ptr = head;
                int pre = head;

                while (n[ptr].next != NULL) {
                    pre = ptr;
                    ptr = n[ptr].next;
                }
                n[pre].next = NULL;
                deleteIndex(pre);
                crnt = pre;
            }
        }
    }

    // record p 삭제
    public void remove(int p) {
        if (head != NULL) {
            if (p == head)
                removeFirst();
            else {
                int ptr = head;

                while (n[ptr].next != p) {
                    ptr = n[ptr].next;
                    if (ptr == NULL) return;
                }

                n[ptr].next = NULL;
                deleteIndex(ptr);
                n[ptr].next = n[p].next;
                crnt = ptr;
            }
        }
    }

    // 선택 노드를 삭제
    public void removeCurrentNode() {
        remove(crnt);
    }

    // 모든 노드를 삭제
    public void clear() {
        while (head != NULL)
            removeFirst();
        crnt = NULL;
    }

    public boolean next() {
        if (crnt == NULL || n[crnt].next == NULL)
            return false;
        crnt = n[crnt].next;
        return true;
    }

    public void printCurrentNode() {
        if (crnt == NULL)
            System.out.println("선택 노드가 없습니다.");
        else
            System.out.println(n[crnt].data);
    }

    public void dump() {
        int ptr = head;

        while (ptr != NULL) {
            System.out.println(n[ptr].data);
            ptr = n[ptr].next;
        }
    }
}
