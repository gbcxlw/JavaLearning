package com.dataStructure.leetcode.链表;

public class _141_环形链表 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head.next;
        while (!fast.equals(head)) {
            if (fast == null || head.next == null)
                return false;
            head = head.next;
            fast = fast.next.next;
        }
        return true;
    }
}
