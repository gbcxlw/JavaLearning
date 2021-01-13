package com.dataStructure.binaryTree;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

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

    public static abstract class Visitor<E> {
        boolean stop;
        abstract boolean visit(E element);
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

    /**
     * 前序遍历
     * @param visitor
     */
//    public void preOrderTraversal(Node<E> node) {
//        if (node == null)
//            return ;
//        System.out.print(node.element + " ");
//        preOrderTraversal(node.left);
//        preOrderTraversal(node.right);
//    }
    public void preOrderTraversal(Visitor<E> visitor) {
        if (visitor == null) return;
        preOrderTraversal(root, visitor);
    }

    public void preOrderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor.stop)
            return;
        visitor.stop = visitor.visit(node.element);

        preOrderTraversal(node.left, visitor);
        preOrderTraversal(node.right, visitor);
    }

    /**
     * 中序遍历
     * @param visitor
     */
//    public void inOrderTraversal(Node<E> node) {
//        if (node == null)
//            return;
//        inOrderTraversal(node.left);
//        System.out.print(node.element + " ");
//        inOrderTraversal(node.right);
//    }

    public void inOrderTraversal(Visitor<E> visitor) {
        if (visitor == null) return;
        inOrderTraversal(root, visitor);
    }

    public void inOrderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor.stop)
            return;
        inOrderTraversal(node.left, visitor);
        if (visitor.stop) return;
        visitor.stop = visitor.visit(node.element);
        inOrderTraversal(node.right, visitor);
    }

    /**
     * 后序遍历
     * @param visitor
     */
    public void postOrderTraversal(Visitor<E> visitor) {
        if (visitor == null) return;
        postOrderTraversal(root, visitor);
    }

    public void postOrderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor.stop)
            return;
        postOrderTraversal(node.left, visitor);
        postOrderTraversal(node.right, visitor);
        if (visitor.stop) return;
        visitor.stop = visitor.visit(node.element);
    }

    /**
     * 层序遍历
     * @param visitor
     */
    public void levelOrderTraversal(Visitor<E> visitor) {
        if (root == null || visitor == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        Node<E> curNode  = null;
        queue.offer(root);
        while (!queue.isEmpty()) {
            curNode = queue.poll();
            if (visitor.visit(curNode.element)) {
                return;
            }
            if (curNode.left != null)
                queue.offer(curNode.left);
            if (curNode.right != null)
                queue.offer(curNode.right);
        }
    }

    /**
     * 获取二叉树高度,递归
     * @param node
     * @return
     */
    public int getHeight(Node<E> node) {
        if (node == null)
            return 0;
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        return left > right ? left + 1 : right + 1;
    }

    public int getHeight() {
        return getHeight(root);
    }

    /**
     * 非递归获取二叉树高度
     * @param node
     * @return
     */
    public int getHeight2(Node<E> node) {
        int height = 0;
        if (root == null)
            return 0;
        Queue<Node> queue = new LinkedList<>();
        Node<E> curNode  = null;
        queue.offer(root);
        int levelCount = 1;
        int i = 0;
        while (!queue.isEmpty()) {
            curNode = queue.poll();
            if (curNode.left != null)
                queue.offer(curNode.left);
            if (curNode.right != null)
                queue.offer(curNode.right);
            i ++;
            if (i == levelCount) {
                height ++;
                levelCount = queue.size();
                i = 0;
            }
        }
        return height;
    }

    public boolean isComplete() {
        Queue<Node> queue = new LinkedList<>();
        Node<E> curNode  = null;
        queue.offer(root);
        boolean isLeaf = false;
        while (!queue.isEmpty()) {
            curNode = queue.poll();
//            if (curNode.right != null && curNode.left == null) {
//                return false;
//            } else if (isLeaf && curNode.left != null) {
//                return false;
//            } else {
//                if (curNode.left != null)
//                    queue.offer(curNode.left);
//                if (curNode.right != null)
//                    queue.offer(curNode.right);
//                if (curNode.left != null && curNode.right == null)
//                    isLeaf = true;
//                if (curNode.left == null && curNode.right == null)
//                    isLeaf = true;
//            }
            if (isLeaf && curNode.left != null && curNode.right != null)
                return false;
            if (curNode.right != null && curNode.left != null) {
                queue.offer(curNode.left);
                queue.offer(curNode.right);
            } else if (curNode.left == null && curNode.right != null) {
                return false;
            } else {
                isLeaf = true;
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
            }


        }
        return false;
    }

    public void invertBinaryTree(Node<E> node) {
        if (node == null)
            return;
        if (node.left == null && node.right == null)
            return;
        Node<E> temp = node.left;
        node.left = node.right;
        node.right = temp;
        if (node.left != null)
            invertBinaryTree(node.left);
        if (node.right != null)
            invertBinaryTree(node.right);
    }


    /**
     * 前驱节点
     * @param node
     * @return
     */
    public Node<E> preDecessor(Node<E> node) {
        if (node == null) return null;

        Node<E> p = node.left;
        //node.left不为null,即前驱节点在左子树中
        if (p != null) {
            while (p.right != null) {
                p = p.right;
            }
            return p;
        }
        //node.left为null,从父节点、祖父节点中寻找前驱节点
        if (node.parent != null && node == node.parent.left) {
            node = node.parent;
        }
        return node.parent;
    }

    /**
     * 后继节点
     * @param node
     * @return
     */
    public Node<E> postDecessor(Node<E> node) {
        if (node == null) return null;

        Node<E> p  = node.right;
        if (p != null) {
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }

        if (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }

        return node.parent;
    }

    public void remove(E element) {
        remove(node(element));
    }

    public void remove(Node<E> node) {
        if (node == null)
            return;

        size--;
    }

    public Node<E> node(E element) {
        Node<E> node = root;
        while (node != null) {
            int cmp = compare(node.element, element);
            if (cmp == 0) {
                return node;
            }

            if (cmp < 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }
}

