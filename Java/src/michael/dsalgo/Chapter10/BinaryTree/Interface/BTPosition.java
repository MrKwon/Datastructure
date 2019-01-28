package michael.dsalgo.Chapter10.BinaryTree.Interface;

public interface BTPosition<E> extends Position<E> {
    @Override
    E element();
    void setElement(E element);

    BTPosition<E> getLeft();
    void setLeft(BTPosition<E> v);

    BTPosition<E> getRight();
    void setRight(BTPosition<E> v);

    BTPosition<E> getParent();
    void setParent(BTPosition<E> v);
}
