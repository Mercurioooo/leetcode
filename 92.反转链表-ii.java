/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 *
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (47.90%)
 * Likes:    257
 * Dislikes: 0
 * Total Accepted:    26.8K
 * Total Submissions: 55.7K
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * 
 * 示例:
 * 
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // return help(head, )
        if (m >= n)
            return head;
        ListNode cur = head;
        if (cur.next == null)
            return null;
        int cnt = 0;
        while (cur != null) {
            cnt++;
            if (cnt == m) {
                cur.next = help(cur.next, n - m);
                return cur;
            }
            cur = cur.next;
        }
        return head;
    }

    private ListNode help(ListNode head, int num) {
        if (num == 1)
            return head;
        ListNode pre = null, cur = head, next = head.next;
        int cnt = 1;
        // while (cnt < num) {
        while (next != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = cur.next;
            cnt++;
        }
        head.next = next;
        System.out.println(cur.val);
        return cur;
    }
}
// @lc code=end
