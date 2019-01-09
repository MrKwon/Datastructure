package michael.dsalgo.Chapter03.DoublyLinkedList;

public class DoublyLinkedList<E> {
    private DNode<E> head, tail;
    private int size;

    public DoublyLinkedList() {
        this.head = new DNode<>(null, null, null);
        this.tail = new DNode<>(null, this.head , null);
        this.head.setNext(this.tail);
        size = 0;
    }

    private void deAlloc(DNode<E> node) {
        node.setElement(null);
        node.setNext(null);
        node.setPrev(null);
    }

    public int size() { return this.size; }
    public boolean isEmpty() { return this.size == 0; }

    public DNode<E> getFirst() {
        return this.head.getNext();
    }

    public DNode<E> getLast() {
        return this.tail.getPrev();
    }

    public void addFirst(E ele) {
        if (size == 0) {
            DNode<E> node = new DNode<>(ele, this.head, this.tail);
            this.head.setNext(node);
            this.tail.setPrev(node);
        } else {
            DNode<E> node = new DNode<>(ele, this.head, this.head.getNext());
            this.head.getNext().setPrev(node);
            this.head.setNext(node);
        }

        size++;
    }

    public void addLast(E ele) {
        if (size == 0)
            addFirst(ele);
        else {
            DNode<E> node = new DNode<>(ele, this.tail.getPrev(), this.tail);
            this.tail.getPrev().setNext(node);
            this.tail.setPrev(node);
        }

        size++;
    }

    public void removeFirst() {
        if (size == 0) {
            System.out.println("list is empty");
            return;
        }

        DNode<E> tmp = this.head.getNext();
        tmp.getNext().setPrev(head);
        this.head.setNext(tmp.getNext());
        // head의 next를 바꿔야 하는데 this.head = tmp.getNext() 를 해서 head 가 이상해졌음 (원래의 풀이에서)

        deAlloc(tmp);
        size--;

//        DNode<E> v = this.head.getNext();
//        DNode<E> u = v.getNext();
//        this.head.setNext(u);
//        u.setPrev(head);
//
//        deAlloc(v);
//        size--;
    }

    public void removeLast() {
        if (size == 0) {
            System.out.println("list is empty");
            return;
        }

        DNode<E> tmp = this.tail.getPrev();
        tmp.getPrev().setNext(tail);
        this.tail.setPrev(tmp.getPrev());
        // head의 next를 바꿔야 하는데 this.head = tmp.getNext() 를 해서 head 가 이상해졌음 (원래의 풀이에서)

        deAlloc(tmp);
        size--;
//        DNode<E> v = this.tail.getPrev();
//        DNode<E> u = v.getPrev();
//        this.tail.setPrev(u);
//        u.setNext(tail);
//
//        deAlloc(v);
//        size--;
    }


    public void addAfter(E point, E ele) {
        if (size == 0) {
            System.out.println("list is empty");
            return;
        }

        DNode<E> ptr = this.head.getNext();
        while (ptr.getElement() != point && ptr.getNext() != null)
            ptr = ptr.getNext();

        if (ptr.getNext() == null) { // ptr 이 tail 이면 리스트에 존재하지 않는 원소임
            System.out.println(point + " is not exist in this list");
            return;
        }

        DNode<E> node = new DNode<>(ele, ptr, ptr.getNext());
        node.getNext().setPrev(node);
        node.getPrev().setNext(node);

        size++;
    }

    public void removeAfter(E point) {
        if (size == 0) {
            System.out.println("list is empty");
            return;
        }

        DNode<E> ptr = this.head;

        while (ptr.getElement() != point)
            ptr = ptr.getNext();

        if (ptr.getNext() == null) { // ptr 이 tail 이면 리스트에 존재하지 않는 원소임
            System.out.println(point + " is not exist in this list");
            return;
        }

        ptr.getNext().setPrev(ptr.getPrev());
        ptr.getPrev().setNext(ptr.getNext());

        deAlloc(ptr);
        size--;
    }

    @Override
    public String toString() {
        long tmpSize = this.size;
        String s = "size : " + tmpSize + " [ ";

        DNode<E> tmp = head.getNext();

        while (tmp != this.tail) {
            s += tmp.getElement();
            tmp = tmp.getNext();
            if (tmp != this.tail) {
                s += ", ";
            }
        }

        s += " ]";

        return s;
    }
}
