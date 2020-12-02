package com.dataStructure.leetcode.链表;

/**
 *
 *
 * @description: https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * @param null
 * @return: 
 * @author: maofei
 * @time: 2020/11/12 9:25
 */
public class _237_删除链表中的节点 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
