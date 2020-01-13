import java.util.LinkedList;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 *
 * https://leetcode-cn.com/problems/validate-binary-search-tree/description/
 *
 * algorithms
 * Medium (27.86%)
 * Likes:    333
 * Dislikes: 0
 * Total Accepted:    51.9K
 * Total Submissions: 186.1K
 * Testcase Example:  '[2,1,3]'
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 
 * 假设一个二叉搜索树具有如下特征：
 * 
 * 
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * ⁠   2
 * ⁠  / \
 * ⁠ 1   3
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * ⁠   5
 * ⁠  / \
 * ⁠ 1   4
 *     / \
 *    3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    LinkedList<TreeNode> stack = new LinkedList();
    LinkedList<Integer> uppers = new LinkedList(), lowers = new LinkedList();

    public void update(TreeNode root, Integer lower, Integer upper) {
        stack.add(root);
        lowers.add(lower);
        uppers.add(upper);
    }

    public boolean isValidBST2(TreeNode root) {
        Integer lower = null, upper = null, val;
        update(root, lower, upper);

        while (!stack.isEmpty()) {
            root = stack.poll();
            lower = lowers.poll();
            upper = uppers.poll();

            if (root == null)
                continue;
            val = root.val;
            if (lower != null && val <= lower)
                return false;
            if (upper != null && val >= upper)
                return false;
            update(root.right, val, upper);
            update(root.left, lower, val);
        }
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // If next element in inorder traversal
            // is smaller than the previous one
            // that's not BST.
            if (root.val <= inorder)
                return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

    public boolean isValidBST1(TreeNode root) {
        if (root == null)
            return true;
        // System.out.println(max(root.left) + " " + min(root.right));
        if (root.left != null && max(root.left) >= root.val)
            return false;
        if (root.right != null && min(root.right) <= root.val)
            return false;
        return isValidBST(root.left) & isValidBST(root.right);
    }

    private int max(TreeNode root) {
        if (root == null)
            return Integer.MIN_VALUE;
        if (root.left == null && root.right == null)
            return root.val;
        else
            return Math.max(root.val, Math.max(max(root.left), max(root.right)));

    }

    private int min(TreeNode root) {
        if (root == null)
            return Integer.MAX_VALUE;
        if (root.left == null && root.right == null)
            return root.val;
        else
            return Math.min(root.val, Math.min(min(root.left), min(root.right)));
    }
}
// @lc code=end
