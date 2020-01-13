import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
 *
 * https://leetcode-cn.com/problems/reorder-list/description/
 *
 * algorithms
 * Medium (52.94%)
 * Likes:    133
 * Dislikes: 0
 * Total Accepted:    11.8K
 * Total Submissions: 22.3K
 * Testcase Example:  '[1,2,3,4]'
 *
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * 示例 1:
 * 
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 
 * 示例 2:
 * 
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public void reorderList(ListNode head) {

        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        int len = 0;
        ListNode h = head;
        // 求出节点数
        while (h != null) {
            len++;
            h = h.next;
        }

        reorderListHelper(head, len);
    }

    private ListNode reorderListHelper(ListNode head, int len) {
        if (len == 1) {
            ListNode outTail = head.next;
            head.next = null;
            return outTail;
        }
        if (len == 2) {
            ListNode outTail = head.next.next;
            head.next.next = null;
            return outTail;
        }
        // 得到对应的尾节点，并且将头结点和尾节点之间的链表通过递归处理
        ListNode tail = reorderListHelper(head.next, len - 2);
        ListNode subHead = head.next;// 中间链表的头结点
        head.next = tail;
        ListNode outTail = tail.next; // 上一层 head 对应的 tail
        tail.next = subHead;
        return outTail;
    }

    // public void reorderList(ListNode head) {
    // // printList(head);
    // if (head == null || head.next == null || head.next.next == null)
    // return;
    // ListNode fast = head;
    // ListNode slow = head;
    // while (fast.next != null && fast.next.next != null) {
    // fast = fast.next.next;
    // slow = slow.next;
    // }
    // ListNode anotherHead = slow.next;
    // slow.next = null;
    // anotherHead = reverseList(anotherHead);
    // // printList(anotherHead);
    // merge(head, anotherHead);

    // }

    private void reverse(ListNode head) {
        ListNode pre = null;
        ListNode next = head.next;
        while (next != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
    }

    private ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode tail = head;
        head = head.next;

        tail.next = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = tail;
            tail = head;
            head = temp;
        }

        return tail;
    }

    private void merge(ListNode head1, ListNode head2) {
        ListNode temp1, temp2;
        while (head1 != null && head2 != null) {
            temp1 = head1.next;
            head1.next = head2;
            temp2 = head2.next;
            head2.next = temp1;
            head1 = temp1;
            head2 = temp2;
        }
    }

    // {
    // if (head == null)
    // return;
    // ArrayList<ListNode> list = new ArrayList<ListNode>();
    // ListNode cur = head;
    // while (cur != null) {
    // list.add(cur);
    // cur = cur.next;
    // }
    // // for (ListNode t : list)
    // // System.out.print(t.val);
    // cur = head;
    // int length = list.size();
    // int a = 0, b = length - 1;
    // while (a < b) {
    // list.get(a).next = list.get(b);
    // a++;
    // if (a == b)
    // break;
    // list.get(b).next = list.get(a);
    // b--;
    // }
    // list.get(a).next = null;

    // }

}
// @lc code=end
