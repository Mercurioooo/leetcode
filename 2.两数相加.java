/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // int length1 = getLength(l1);
        // int length2 = getLength(l2);
        // System.out.println(length1 + " " + length2);
        // ListNode temp;
        // if (length1 < length2) {// 始终保持l1是较长的那一个
        // temp = l1;
        // l1 = l2;
        // l2 = temp;
        // }
        // int diff = Math.abs(length1 - length2);

        ListNode head = new ListNode(0);
        ListNode p = head;
        // while (diff != 0) {
        // p.next = new ListNode(l1.next.val);
        // p = p.next;
        // l1 = l1.next;
        // diff--;
        // }
        int jin = 0;
        int ans;
        int x, y;
        while (l1 != null || l2 != null) {
            x = l1 == null ? 0 : l1.val;
            y = l2 == null ? 0 : l2.val;
            ans = x + y + jin;
            p.next = new ListNode(ans % 10);
            if (head == null)
                head = p;
            jin = ans / 10;
            System.out.println(ans + "+" + jin);
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
            p = p.next;
        }
        if (jin > 0)
            p.next = new ListNode(jin);
        return head.next;

    }

    public int getLength(ListNode l) {
        int length = 0;
        while (l != null) {
            l = l.next;
            length++;
        }
        return length;
    }
}
// @lc code=end
