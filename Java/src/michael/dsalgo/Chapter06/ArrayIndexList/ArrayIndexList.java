package michael.dsalgo.Chapter06.ArrayIndexList;

import java.util.Arrays;

import static java.util.Objects.checkIndex;

public class ArrayIndexList<E> implements IndexList<E> {
    private E[] A;
    private int capacity = 16;
    private int size = 0;

    public ArrayIndexList() {
        A = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        return A[i];
    }

    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
        E tmp = A[i];
        A[i] = e;
        return tmp;
    }

    @Override
    public void add(int r, E e) throws IndexOutOfBoundsException {
        checkIndex(r, size() + 1);
        if (size == capacity) {
            System.out.println("!!! Size Up !!!");
            capacity *= 2;
            E[] B = (E[]) new Object[capacity];
            for (int i = 0; i < size; i++)
                B[i] = A[i];

            A = B;
        }

        for (int i = size - 1; i >= r; i--)
            A[i + 1] = A[i];

        A[r] = e;
        size++;
    }

    @Override
    public E remove(int r) throws IndexOutOfBoundsException {
        checkIndex(r, size());
        E tmp = A[r];
        for (int i = r; i < size - 1; i++)
            A[i] = A[i + 1];
        size--;
        return tmp;
    }

    @Override
    public String toString() {
        String s1 = "";

        s1 += "[capacity = " + capacity + "] [size = " + size + "]\n";

        String sIndex = "";
        String sElement = "";
        if (!isEmpty()) {
            for (int i = 0; i < size(); i++) {
                sIndex += "[ " + i + " ]";
                sElement += "[ " + A[i] + " ]";
            }


            sIndex += "\n";
            sElement += "\n";

            return s1 + sIndex + sElement;
        } {
            s1 += "[ Empty List ]";

            return s1;
        }

    }
}
