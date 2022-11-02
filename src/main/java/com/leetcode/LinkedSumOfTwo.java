package com.leetcode;

/**
 * leetcode2
 * 单链表，两数之和
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 * @Auth ZhangWeiWei
 * @Date 2022/11/1
 **/
public class LinkedSumOfTwo {

  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    // 核心思想：线性扫描链表，增加空头、尾节点，ListNode head, tail = null
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int tempValue = 0, num1 = 0, num2 = 0;
        while (l1 != null || l2 != null) {

            if (l1 != null) {
                num1 = l1.val;
                l1 = l1.next;
            } else {
                num1 = 0;
            }

            if (l2 != null) {
                num2 = l2.val;
                l2 = l2.next;
            } else {
                num2 = 0;
            }

            int sum = num1 + num2 + tempValue;
            int value = 0;
            if (sum >= 10) {
                tempValue = 1;
                value = sum - 10;
            } else {
                tempValue = 0;
                value = sum;
            }
            if (head == null) {
                head = tail = new ListNode(value);
            } else {
                tail.next = new ListNode(value);
                tail = tail.next;
            }
        }

        if (tempValue > 0) {
            tail.next = new ListNode(tempValue);
        }
        return head;
    }

}
