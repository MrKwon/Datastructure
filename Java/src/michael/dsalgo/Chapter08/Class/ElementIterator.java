package michael.dsalgo.Chapter08.Class;

import michael.dsalgo.Chapter08.Interface.Data.Position;
import michael.dsalgo.Chapter08.Interface.List.PositionList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ElementIterator<E> implements Iterator<E> {
    private PositionList<E> list;
    private Position<E> cursor;

    public ElementIterator(PositionList<E> list) {
        this.list = list;
        this.cursor = (list.isEmpty()) ? null : list.first();
    }

    @Override
    public boolean hasNext() {
        return (cursor != null);
    }

    @Override
    public E next() throws NoSuchElementException {
        if (cursor == null) throw new NoSuchElementException("No next element");

        E toReturn = cursor.element();
        cursor = (cursor == list.last()) ? null : list.next(cursor);

        return toReturn;
    }
}
