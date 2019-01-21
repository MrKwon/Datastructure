package michael.dsalgo.Chapter08.Interface.Tree;

import michael.dsalgo.Chapter08.Exceptions.TreeExceptions.*;
import michael.dsalgo.Chapter08.Interface.Data.Position;

public interface BinaryTree<E> extends Tree<E> {
    public Position<E> left(Position<E> v)
            throws InvalidPositionException, BoundaryViolationException;

    public Position<E> right(Position<E> v)
            throws InvalidPositionException, BoundaryViolationException;

    public boolean hasLeft(Position<E> v);

    public boolean hasRight(Position<E> v);
}
