/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
 *
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/description/
 *
 * algorithms
 * Medium (66.06%)
 * Likes:    210
 * Dislikes: 0
 * Total Accepted:    19.2K
 * Total Submissions: 29K
 * Testcase Example:  '[1,2,5,3,4,null,6]'
 *
 * 给定一个二叉树，原地将它展开为链表。
 * 
 * 例如，给定二叉树
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   5
 * ⁠/ \   \
 * 3   4   6
 * 
 * 将其展开为：
 * 
 * 1
 * ⁠\
 * ⁠ 2
 * ⁠  \
 * ⁠   3
 * ⁠    \
 * ⁠     4
 * ⁠      \
 * ⁠       5
 * ⁠        \
 * ⁠         6
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public void flatten(TreeNode root) {
        while (root != null) {
            // System.out.println(root.val);
            if (root.left != null) {
                TreeNode most_right = root.left; // 如果左子树不为空, 那么就先找到左子树的最右节点
                while (most_right.right != null)
                    most_right = most_right.right; // 找最右节点
                most_right.right = root.right; // 然后将跟的右孩子放到最右节点的右子树上
                root.right = root.left; // 这时候跟的右孩子可以释放, 因此我令左孩子放到右孩子上
                root.left = null; // 将左孩子置为空
            }
            root = root.right; // 继续下一个节点
        }
        return;
    }

}
// @lc code=end
