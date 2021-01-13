package com.dataStructure.leetcode.链表;

public class _2_两数相加 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        l2.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next = new ListNode(9);
        l2.next.next.next.next.next.next = new ListNode(9);
        addTwoNumbers(l1, l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = new ListNode();
        ListNode root = l;
        int temp = 0;    //进位
        while (l1 != null || l2 != null) {
            int firstNum = l1 == null ? 0 : l1.val;
            int secondNum = l2 == null ? 0 : l2.val;
            int count = firstNum + secondNum + temp;
            temp = count / 10;
//            System.out.println(l.val);
            l.next = new ListNode(count % 10);
            l = l.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (temp != 0)
            l.next = new ListNode(temp);

        while (root.next != null) {
            System.out.println(root.next.val);
            root = root.next;
        }
        return root.next;
    }
}
