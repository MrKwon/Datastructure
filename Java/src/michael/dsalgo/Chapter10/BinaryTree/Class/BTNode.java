package michael.dsalgo.Chapter10.BinaryTree.Class;

import michael.dsalgo.Chapter10.BinaryTree.Interface.BTPosition;

public class BTNode<E> implements BTPosition<E> {
    private E element;
    private BTPosition<E> left, right, parent;

    public BTNode(E element,
                  BTPosition<E> parent, BTPosition<E> left, BTPosition<E> right) {
        setElement(element);
        setParent(parent);
        setLeft(left);
        setRight(right);
    }

    @Override
    public E element() {
        return element;
    }

    @Override
    public void setElement(E element) {
        this.element = element;
    }

    @Override
    public BTPosition<E> getLeft() {
        return left;
    }

    @Override
    public void setLeft(BTPosition<E> left) {
        this.left = left;
    }

    @Override
    public BTPosition<E> getRight() {
        return right;
    }

    @Override
    public void setRight(BTPosition<E> right) {
        this.right = right;
    }

    @Override
    public BTPosition<E> getParent() {
        return parent;
    }

    @Override
    public void setParent(BTPosition<E> parent) {
        this.parent = parent;
    }
}
