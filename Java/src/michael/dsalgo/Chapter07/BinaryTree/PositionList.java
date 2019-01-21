package michael.dsalgo.Chapter07.BinaryTree;

import michael.dsalgo.Chapter06.PositionList.PositionException.BoundaryViolentException;
import michael.dsalgo.Chapter06.PositionList.PositionException.InvalidPositionException;

import java.util.Iterator;

public interface PositionList<E> extends Iterable<E>{
    /**
     * @return the number of elements in this list
     */
    public int size();

    /**
     * @return whether the list is empty
     */
    public boolean isEmpty();

    /**
     * @return the first node in the list
     */
    public Position<E> first();

    /**
     * @return the last node in the list
     */
    public Position<E> last();

    /**
     * @param p position of given node
     * @return the node after a given node in the list
     * @throws InvalidPositionException if position is invalid
     * @throws BoundaryViolentException !!
     */
    public Position<E> next(Position p) throws InvalidPositionException, BoundaryViolentException;

    /**
     * @param p position of given node
     * @return the node before a given node in the list
     * @throws InvalidPositionException if position is invalid
     * @throws BoundaryViolentException !!
     */
    public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolentException;

    /**
     * Inserts an element at the front of the list, returning new position
     * @param e an element to insert
     */
    public void addFirst(E e);

    /**
     * Inserts an element at the last of the list, returning new position
     * @param e an element to insert
     */
    public void addLast(E e);

    /**
     * Inserts an element after the given node in the list
     * @param p an element to insert
     * @param e position of given node
     * @throws InvalidPositionException if position is invalid
     */
    public void addAfter(Position<E> p, E e) throws InvalidPositionException;

    /**
     * Inserts an element before the given node in the list
     * @param p an element to insert
     * @param e position of given node
     * @throws InvalidPositionException if position is invalid
     */
    public void addBefore(Position<E> p, E e) throws InvalidPositionException;

    /**
     * Removes a node from the list, returning the element stored there
     * @param p position to remove
     * @return originally stored element at position p
     * @throws InvalidPositionException if position is invalid
     */
    public E remove(Position<E> p) throws InvalidPositionException;

    /**
     * Replaces the element stored at the given node, returning old element
     * @param p position to replace
     * @param e new element to replace old element
     * @return old element
     * @throws InvalidPositionException if position is invalid
     */
    public E set(Position<E> p, E e) throws InvalidPositionException;

    /**
     * @return an iterator of all the elements in the list
     */
    @Override
    Iterator<E> iterator();

    /**
     * @return an iterable collection of all the nodes in th list
     */
    public Iterable<Position<E>> positions();
}
