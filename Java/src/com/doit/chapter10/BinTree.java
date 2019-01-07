package com.doit.chapter10;

import java.util.Comparator;

public class BinTree<K, V> {
    static class Node<K, V> {
        private K key;
        private V data;
        private Node<K, V> left;
        private Node<K, V> right;

        public Node(K key, V value, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.data = value;
            this.left = left;
            this.right = right;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.data;
        }

        public void print() {
            System.out.println(this.data);
        }
    }

    private Node<K, V> root;
    private Comparator<? super K> comparator = null;

    public BinTree() {
        root = null;
    }

    public BinTree(Comparator<? super K> comparator) {
        this();
        this.comparator = comparator;
    }

    private int comp(K key1, K key2) {
        return (comparator == null) ? ((Comparable<K>)key1).compareTo(key2) : comparator.compare(key1, key2);
    }

    public V search(K key) {
        Node<K, V> p = root;

        while (true) {
            if (p == null)
                return null;
            int cond = comp(key, p.getKey());
            if (cond == 0)
                return p.getValue();
            else if (cond < 0)
                p = p.left;
            else
                p = p.right;
        }
    }

    // node 를 루트로 하는 서브트리에 노드 <K, V> 를 삽입
    private void addNode(Node<K, V> node, K key, V data) {
        int cond = comp(key, node.getKey());
        if (cond == 0)
            return;
        else if (cond < 0) {
            if (node.left == null)
                node.left = new Node<>(key, data, null, null);
            else
                addNode(node.left, key, data);
        } else {
            if (node.right == null)
                node.right = new Node<>(key, data, null, null);
            else
                addNode(node.right, key, data);
        }
    }
}
