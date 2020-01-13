import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Medium (68.94%)
 * Likes:    324
 * Dislikes: 0
 * Total Accepted:    79.7K
 * Total Submissions: 115.4K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的中序 遍历。
 * 
 * 示例:
 * 
 * 输入: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * 输出: [1,3,2]
 * 
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    class ColorNode {
        TreeNode node;
        boolean color;

        public ColorNode(TreeNode node, boolean color) {
            this.node = node;
            this.color = color;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<Integer>();

        List<Integer> res = new ArrayList<>();
        Stack<ColorNode> stack = new Stack<>();
        stack.push(new ColorNode(root, true));

        while (!stack.empty()) {
            ColorNode cn = stack.pop();

            if (cn.color) {
                if (cn.node.right != null)
                    stack.push(new ColorNode(cn.node.right, true));
                stack.push(new ColorNode(cn.node, false));
                if (cn.node.left != null)
                    stack.push(new ColorNode(cn.node.left, true));
            } else {
                res.add(cn.node.val);
            }
        }

        return res;
    }
}
// @lc code=end
