package michael.dsalgo.Chapter03.SinglyLinkedList;

public class SinglyLinkedList<E> {

    protected Node<E> head;
    protected long size;

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void addFirst(E ele) {
        Node<E> ptr = this.head;
        this.head = new Node<>(ele, ptr);

        this.size += 1;
    }

    public void addLast(E ele) {
        if (head == null)
            addFirst(ele);
        else {
            Node<E> p = this.head;
            while (p.getNext() != null)
                p = p.getNext(); // p는 마지막 Node의 참조

            p.setNext(new Node<>(ele, null));
        }

        this.size += 1;
    }

    public void removeFirst() {
        if (head == null) // 비어있을 땐 지울 게 없음
            return;

        Node<E> tmp = this.head; // head의 참조를 변수객체 tmp에 저장
        this.head = this.head.getNext(); // head에는 head의 next를 저장
        tmp.setNext(null); // tmp 사용 해제
        size -= 1; // 하나 지웠으니까 size 줄임
    }

    public void removeLast() {
        if (head == null)
            return;
        else if (head.getNext() == null) {
            removeFirst();
            return;
        }

        Node<E> ptr = this.head;
        while (ptr.getNext().getNext() != null) {
            ptr = ptr.getNext(); // 마지막 원소 이전의 원소
        }

        ptr.getNext().setElement(null); // 마지막 원소 ele을 null로 만들어서 메모리 해제
        ptr.setNext(null); // 마지막 원소를 가리키는 이전의 원소 포인터 해제
        this.size -= 1;
    }

    @Override
    public String toString() {
        long tmpSize = this.size;
        String s = "size : " + tmpSize + " [ ";

        Node<E> tmp = head;

        while (tmp != null) {
            s += tmp.getElement();
            tmp = tmp.getNext();
            if (tmp != null) {
                s += ", ";
            }
        }

        s += " ]";

        return s;
    }
}
