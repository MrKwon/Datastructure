package michael.dsalgo.Chapter03;

public class SinglyLinkedList {
    public class Node<E> {
        private E element;
        private Node<E> next;

        public Node() {
            this.element = null;
            this.next = null;
        }

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    public class SLinkedList<E> {
        protected Node<E> head;
        protected long size;

        public SLinkedList() {
            this.head = null;
            this.size = 0;
        }

        public void addFirst(E ele) {
            Node<E> add = new Node<>(); // ele 을 추가하기 위한 Node 생성
            add.setElement(ele); // add의 element를 ele로 set

            if (head == null) // 비어있으면
                add.setNext(null); // 추가하면 뒤에 아무것도 없으므로 null
            else  // 비어있지 않으면
                add.setNext(head.getNext()); // add의 next를 head가 원래 가리키던 Node로 set

            this.head = add; // add가 맨 앞에 추가되므로 head가 가리키는건 add가 됨
            this.size += 1;
        }

        public void addLast(E ele) {
            Node<E> add = new Node<>();
            add.setElement(ele);
            add.setNext(null);

            if (head == null)
                this.head = add;
            else {
                Node<E> p = this.head;
                while (p.next != null)
                    p = p.getNext(); // p는 마지막 Node의 참조

                p.setNext(add);
            }

            this.size += 1;
        }

        public boolean removeFirst() {
            if (head == null) // 비어있을 땐 지울 게 없음
                return false;

            Node<E> tmp = this.head; // head의 참조를 변수객체 tmp에 저장
            this.head = this.head.getNext(); // head에는 head의 next를 저장
            tmp.setNext(null); // tmp 사용 해제
            size -= 1; // 하나 지웠으니까 size 줄임
            return true;
        }
    }
}
