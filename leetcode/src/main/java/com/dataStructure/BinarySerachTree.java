package com.dataStructure;

import java.util.Comparator;

class BinarySearchTree<E> {
    private int size;
    private Node<E> root;
    private Comparator<E> comparator;

    private static class Node<E> {
        E element;
        Node<E> parent;
        Node<E> left;
        Node<E> right;

        Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
    }

    public BinarySearchTree() {
        this.comparator = null;
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Node<E> getRoot() {
        return root;
    }

    public void add(E element) {
        if (root == null) {
            root = new Node<E>(element, null);
            return;
        }
        Node<E> node  = root;
        Node<E> parent = node;
        int cmp = 0;
        while (node != null) {
            cmp = compare(element, node.element);
            parent = node;
            if (cmp > 0) {
                node = node.right;
            } else if (cmp < 0) {
                node = node.left;
            } else {
                node.element = element;
                return;
            }
        }
        Node<E> newNode = new Node<E>(element, parent);
        if (cmp > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size ++;
    }

    private int compare(E e1, E e2) {
        if (this.comparator != null)
            return comparator.compare(e1, e2);
        return ((Comparable<E>) e1).compareTo(e2);
    }

    public void preOrderTraversal(Node<E> node) {
        if (node == null)
            return;
        System.out.println(node.element);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

}
