/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/description/
 *
 * algorithms
 * Medium (44.45%)
 * Likes:    173
 * Dislikes: 0
 * Total Accepted:    24.7K
 * Total Submissions: 55.4K
 * Testcase Example:  '[1,2,3,3,4,4,5]'
 *
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * 
 * 示例 1:
 * 
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 
 * 
 * 示例 2:
 * 
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while(p.next.next!=null){
            if(p.next.val == p.next.next.val){    
                ListNode q = p.next.next;
                while(q!=null&&q.val == p.next.val){
                    q = q.next;
                }
                if(q == null) {
                    p.next = q;
                    return dummy.next;
                }
                else p.next = q;
            }
            else p = p.next;
        }
        return dummy.next;
    }
}
/*

if(p.next.val == p.next.next.val){
                ListNode q = p.next.next;
                while(q.next!=null && q.val == p.next.val){
                    q = q.next;
                }
                p.next = q;
                continue;
            }
            p = p.next;
*/
// @lc code=end

