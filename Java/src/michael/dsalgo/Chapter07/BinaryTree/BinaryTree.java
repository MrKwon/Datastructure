package michael.dsalgo.Chapter07.BinaryTree;

import michael.dsalgo.Chapter07.TreeExceptions.*;

public interface BinaryTree<E> extends Tree<E> {
    public Position<E> left(Position<E> v)
        throws InvalidPositionException, BoundaryViolationException;

    public Position<E> right(Position<E> v)
        throws InvalidPositionException, BoundaryViolationException;

    public boolean hasLeft(Position<E> v);

    public boolean hasRight(Position<E> v);
}
