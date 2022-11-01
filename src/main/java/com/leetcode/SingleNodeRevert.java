package com.leetcode;

/**
 * 单链表反转
 *
 * @Auth ZhangWeiWei
 * @Date 2022/8/21
 **/
public class SingleNodeRevert {

    static class ListNode {
        private Object value;
        private ListNode next;

        public ListNode(Object value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }

    // 迭代
    static ListNode foreachNodes(ListNode head) {
        ListNode prev = null, next;
        ListNode curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // 递归
    static ListNode foreachNodes2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newNode = foreachNodes2(head.next); // 拿到head的前一个节点
        head.next.next = head;
        head.next = null;
        return newNode;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, null);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(3, node2);
        ListNode node4 = new ListNode(4, node3);

        ListNode newNode = foreachNodes2(node4);
          System.out.println(newNode);
    }
}
