/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 *
 * https://leetcode-cn.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (63.11%)
 * Likes:    334
 * Dislikes: 0
 * Total Accepted:    45.3K
 * Total Submissions: 71.5K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 
 * 说明：每次只能向下或者向右移动一步。
 * 
 * 示例:
 * 
 * 输入:
 * [
 * [1,3,1],
 * ⁠ [1,5,1],
 * ⁠ [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        int length = grid.length;
        if (length == 0)
            return 0;
        int width = grid[0].length;
        if (width == 0)
            return 0;
        // int[][] dp = new int[length][width];
        int[] dp = new int[width];
        // dp[0][0] = grid[0][0];
        dp[0] = grid[0][0];
        for (int j = 1; j < width; j++)
            dp[j] = dp[j - 1] + grid[0][j];
        // for (int j = 0; j < width; j++)
        // System.out.print(dp[j]);
        // System.out.println();
        // int pre = grid[0][0];
        for (int i = 1; i < length; i++) {
            // pre = grid[i][0];
            dp[0] = dp[0] + grid[i][0];
            // System.out.print(dp[0]);
            for (int j = 1; j < width; j++) {
                // dp[i][j] = Math.min(dp[i][j - 1] + grid[i][j], dp[i - 1][j] + grid[i][j]);
                dp[j] = Math.min(dp[j - 1] + grid[i][j], dp[j] + grid[i][j]);
                // System.out.print(dp[j]);
            }
            // System.out.println();
        }
        // for (int[] hang : grid) {
        // for (int i : hang) {
        // System.out.print(i);
        // }
        // System.out.println();
        // }
        // for (int[] hang : dp) {
        // for (int i : hang) {
        // System.out.print(i);
        // }
        // System.out.println();
        // }
        return dp[width - 1];
    }
}
// @lc code=end
