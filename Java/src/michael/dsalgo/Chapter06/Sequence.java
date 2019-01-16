package michael.dsalgo.Chapter06;

import michael.dsalgo.Chapter05.Deque.Deque;
import michael.dsalgo.Chapter06.ArrayIndexList.IndexList;
import michael.dsalgo.Chapter06.PositionList.*;
import michael.dsalgo.Chapter06.PositionList.PositionException.*;

public interface Sequence<E> extends Deque<E>, IndexList<E>, PositionList<E> {
    public Position<E> atIndex(int r) throws BoundaryViolentException;
    public int indexOf(Position<E> p) throws InvalidPositionException;
}
