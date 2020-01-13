import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层次遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * algorithms
 * Medium (52.56%)
 * Likes:    115
 * Dislikes: 0
 * Total Accepted:    23.9K
 * Total Submissions: 45.5K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回锯齿形层次遍历如下：
 * 
 * [
 * ⁠ [3],
 * ⁠ [20,9],
 * ⁠ [15,7]
 * ]
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ans = new ArrayList<List<Integer>>();
        if (root == null)
            return ans;
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        boolean direction = false;
        deque.add(root);
        while (!deque.isEmpty()) {
            int levelLength = deque.size();
            List<Integer> temp = new ArrayList<Integer>();
            for (int i = 0; i < levelLength; i++) {
                TreeNode now;
                // if (direction)
                now = deque.removeFirst();
                // else
                // now = deque.removeLast();
                temp.add(now.val);
                if (direction) {
                    if (now.left != null)
                        deque.add(now.left);
                    if (now.right != null)
                        deque.add(now.right);
                } else {
                    if (now.right != null)
                        deque.add(now.right);
                    if (now.left != null)
                        deque.add(now.left);
                }
            }
            direction = !direction;
            ans.add(temp);
        }
        return ans;

    }
}
// @lc code=end
