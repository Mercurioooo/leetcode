/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (62.65%)
 * Likes:    277
 * Dislikes: 0
 * Total Accepted:    32K
 * Total Submissions: 51K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 */
class Solution {
    int[] preorder;
    int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
    }

    private helper(int ps,int pe,int is,int ie){
        TreeNode root = new TreeNode(preorder[ps]);
        int i;
        for(i = is;i<ie;i++){
            if(inorder[i] == root.val) break; 
        }
        int numLeft = i - ie;
        int numRight = ie - i;
        TreeNode left = helper(ps+1,pe,ps+numLeft,is+);
    }
}
// @lc code=end

/**
 * * ⁠ 3 ⁠ / \ ⁠ 9 20 ⁠ / \ ⁠ 15 7
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */