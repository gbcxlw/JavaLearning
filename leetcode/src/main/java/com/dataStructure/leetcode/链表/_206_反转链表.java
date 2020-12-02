package com.dataStructure.leetcode.链表;
/**
 *
 *
 * @description: https://leetcode-cn.com/problems/reverse-linked-list/
 * @param null
 * @return: 
 * @author: maofei
 * @time: 2020/11/12 9:42
 */    

public class _206_反转链表 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
