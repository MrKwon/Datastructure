package michael.dsalgo.Chapter08.Interface.Tree;

import michael.dsalgo.Chapter08.Exceptions.TreeExceptions.*;
import michael.dsalgo.Chapter08.Interface.Data.Position;

import java.util.Iterator;

public interface Tree<E> {
    public int size();

    public boolean isEmpty();

    public Iterator<E> iterator();

    public Iterable<Position<E>> positions();

    public E replace(Position<E> v, E e)
            throws InvalidPositionException;

    public Position<E> root()
            throws EmptyTreeException;

    public Position<E> parent(Position<E> v)
            throws InvalidPositionException, BoundaryViolationException;

    public Iterable<Position<E>> children(Position<E> v)
            throws InvalidPositionException;

    public boolean isInternal(Position<E> v)
            throws InvalidPositionException;

    public boolean isExternal(Position<E> v)
            throws InvalidPositionException;

    public boolean isRoot(Position<E> v)
            throws InvalidPositionException;
}
