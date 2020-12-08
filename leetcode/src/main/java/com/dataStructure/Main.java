package com.dataStructure;

import java.util.Comparator;

public class Main {
    private static class personComparator implements Comparator<Person> {
        public int compare(Person e1, Person e2) {
            return e2.getAge() - e1.getAge();
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Person> bst = new BinarySearchTree<Person>(new personComparator());
        bst.add(new Person("first", 13));
        bst.add(new Person("first", 14));

        BinarySearchTree<Person> bst2 = new BinarySearchTree<Person>();
        bst2.add(new Person("first", 13));
        bst2.add(new Person("first", 14));

        BinarySearchTree<Integer> bst3 = new BinarySearchTree<>();
        Integer[] datas = new Integer[] {7, 4, 9, 2, 5, 8, 11, 3, 12, 1};

        for (int i = 0; i < datas.length; i++) {
            bst3.add(datas[i]);
        }
        bst3.preOrderTraversal(bst3.getRoot());
    }
}
