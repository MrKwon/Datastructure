package com.doit.chapter07;

public class IntSet {
    private int max; // 집합의 최대 개수
    private int num; // 집합의 요소 개수
    private int[] set; // 집합 본체

    // Constructor
    public IntSet(int capacity) {
        this.num = 0;
        this.max = capacity;
        try {
            this.set = new int[this.max];
        } catch (OutOfMemoryError e) {
            this.max = 0;
        }
    }

    // return IntSet max(capacity)
    public int capacity() {
        return this.max;
    }

    // return IntSet num(size)
    public int size() {
        return this.num;
    }

    // searching n and return index of n
    public int indexOf(int n) {
        for (int i = 0; i < this.num; i++)
            if (this.set[i] == n)
                return i;
        return -1;
    }

    // check if n is in set
    public boolean constains(int n) {
        return (indexOf(n) != -1);
    }

    // add n into IntSet
    public boolean add(int n) {
        if (this.num >= this.max || constains(n))
            return false;
        else {
            this.set[this.num++] = n;
            return true;
        }
    }

    public boolean remove(int n) {
        int index;

        if (this.num <= 0 || (index = indexOf(n)) == -1)
            return false;
        else {
            this.set[index] = this.set[--this.num];
            return true;
        }
    }

    public void copyTo(IntSet s) {
        int n = (s.max < this.num) ? s.max : this.num; // 복사할 요소 개수
        for (int i = 0; i < n; i++) {
            s.set[i] = this.set[i];
        }
        s.num = n;
    }

    public void copyFrom(IntSet s) {
        int n = (this.max < s.num) ? this.max : s.num;
        for (int i = 0; i < n; i++) {
            this.set[i] = s.set[i];
        }
        this.num = n;
    }

    public boolean equalTo(IntSet s) {
        if (this.num != s.num)
            return false;

        for (int i = 0; i < this.num; i++) {
            int j = 0;
            for ( ; j < s.num; j++) {
                if (this.set[i] == s.set[j]) {
                    break;
                }
            }
            if (j == s.num)
                return false;
        }
        return true;
    }

    public void unionOf(IntSet s1, IntSet s2) {
        copyFrom(s1);
        for (int i = 0; i < s2.num; i++)
            add(s2.set[i]);
    }

    public boolean isEmpty() {
        return (this.num == 0);
    }

    public boolean isFull() {
        return (this.num == this.max);
    }

    public void clear() {
        this.num = 0;
        this.set = null;
        try {
            this.set = new int[this.max];
        } catch (OutOfMemoryError e) {
            this.max = 0;
        }
    }

    public boolean add(IntSet s) {
        this.unionOf(this, s);
        return true;
    }

    public boolean retain(IntSet s) {
        for (int i = 0; i < this.num; i++) {
            if (!this.add(this.set[i])) {
                this.remove(s.set[i]);
            }
        }

        if (this.num == 0) {
            return false;
        }

        return true;
    }

    public boolean remove(IntSet s) {
        for (int i = 0; i < this.num; i++) {
            this.remove(s.set[i]);
        }

        if (this.num == 0)
            return false;

        return true;
    }

    public boolean isSubsetOf(IntSet s) {
        if (this.remove(s))
            return true;
        return false;
    }

    public boolean isProperSubsetOf(IntSet s) {
        if (isSubsetOf(s) && this.set == s.set)
            return true;
        return false;
    }

    @Override
    public String toString() {
        StringBuffer temp = new StringBuffer("{ ");
        for (int i = 0; i < this.num; i++)
            temp.append(set[i] + " ");
        temp.append("}");
        return temp.toString();
    }
}
