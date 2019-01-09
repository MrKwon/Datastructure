package michael.dsalgo.Chapter03.BookEx;

import michael.dsalgo.Chapter03.SinglyLinkedList.Node;

/**
 * no Main
 * @param <E> Node 가 담을 ele 의 자료형
 */
public class CircleList<E> {
    protected Node<E> cursor;
    protected int size;

    public CircleList() { this.cursor = null; this.size = 0;}

    public int size() { return this.size; }

    public Node getCursor() { return this.cursor; }

    public void advance() { cursor = cursor.getNext(); }

    public void add(Node newNode) {
        if (cursor == null) {
            newNode.setNext(newNode);
            cursor = newNode;
        } else {
            newNode.setNext(cursor.getNext());
            cursor.setNext(newNode);
        }

        size++;
    }

    public Node remove() {
        Node<E> oldNode = cursor.getNext();
        if (oldNode == cursor)
            cursor = null;
        else {
            cursor.setNext(oldNode.getNext());
            oldNode.setNext(null);
        }
        size--;
        return oldNode;
    }

    @Override
    public String toString() {
        if (cursor == null) return "[]";
        String s = "[..." + cursor.getElement();
        Node oldCursor = cursor;
        for (advance(); oldCursor != cursor; advance())
            s += ", " + cursor.getElement();
        return s + "...]";
    }
}
