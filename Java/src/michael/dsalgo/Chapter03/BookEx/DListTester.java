package michael.dsalgo.Chapter03.BookEx;

import michael.dsalgo.Chapter03.DoublyLinkedList.DNode;

public class DListTester {
    public static void sort(DList list) {
        if (list.size() <= 1) return;

        DNode pivot;
        DNode ins;
        DNode end = list.getFirst();

        while (end != list.getLast()) {
            pivot = end.getNext();
            list.remove(pivot);
            ins = end;
            while (list.hasPrev(ins) && // Tester에서 int로만 할거라서 그냥 element를 명시적 형변환시킴
                    (int)ins.getElement() > (int)pivot.getElement()) {
                ins = ins.getPrev();
            }
            list.addAfter(ins, pivot);
            if (ins == end)
                end = end.getNext();
        }
    }

    public static void main(String[] args) {

    }
}
