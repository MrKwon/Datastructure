package michael.dsalgo.Chapter08.Interface.Tree;

import michael.dsalgo.Chapter08.Exceptions.TreeExceptions.*;
import michael.dsalgo.Chapter08.Interface.Data.Position;

public interface CompleteBinaryTree<E> extends BinaryTree<E> {
    public Position<E> add(E element);
    public E remove() throws EmptyTreeException;
}
