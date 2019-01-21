package michael.dsalgo.Chapter09;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ElementIterator<E> implements Iterator<E> {
    PositionList<E> list;
    Position<E> cursor;

    public ElementIterator(PositionList<E> list) {
        this.list = list;
        this.cursor = this.list.isEmpty() ? null : this.list.first();
    }

    @Override
    public boolean hasNext() { return this.cursor != null; }

    @Override
    public E next() {
        if (this.cursor == null) throw new NoSuchElementException("No Such Element");

        E toReturn = this.cursor.element();
        this.cursor = (this.cursor == this.list.last()) ? null : this.list.next(this.cursor);

        return null;
    }
}
