/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 *
 * https://leetcode-cn.com/problems/unique-paths-ii/description/
 *
 * algorithms
 * Medium (31.85%)
 * Likes:    193
 * Dislikes: 0
 * Total Accepted:    31.3K
 * Total Submissions: 98.1K
 * Testcase Example:  '[[0,0,0],[0,1,0],[0,0,0]]'
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 
 * 
 * 
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * 
 * 说明：m 和 n 的值均不超过 100。
 * 
 * 示例 1:
 * 
 * 输入:
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * 
 * 
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int length = obstacleGrid.length;
        if (length == 0)
            return 0;
        int width = obstacleGrid[0].length;
        if (width == 0)
            return 0;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[length - 1][width - 1] == 1)
            return 0;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int j = 1; j < width; j++)
            dp[j] = obstacleGrid[0][j] == 1 ? 0 : dp[j - 1];
        int flag1 = 0, pre;
        for (int i = 1; i < length; i++) {
            if (obstacleGrid[i][0] == 1)
                flag1 = 1;
            if (flag1 == 1)
                pre = 0;
            else
                pre = 1;
            for (int j = 1; j < width; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                    pre = 0;
                    continue;
                }
                dp[j] = dp[j] + pre;
                pre = dp[j];
            }
        }
        return dp[width - 1];
    }
}
// @lc code=end
