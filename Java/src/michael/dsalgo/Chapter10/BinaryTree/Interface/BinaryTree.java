package michael.dsalgo.Chapter10.BinaryTree.Interface;

import michael.dsalgo.Chapter07.TreeExceptions.BoundaryViolationException;
import michael.dsalgo.Chapter07.TreeExceptions.InvalidPositionException;

public interface BinaryTree<E> extends Tree<E> {
    public Position<E> left(Position<E> v)
        throws InvalidPositionException, BoundaryViolationException;

    public Position<E> right(Position<E> v)
        throws InvalidPositionException, BoundaryViolationException;

    public boolean hasLeft(Position<E> v);

    public boolean hasRight(Position<E> v);
}
