import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 *
 * https://leetcode-cn.com/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (37.61%)
 * Likes:    244
 * Dislikes: 0
 * Total Accepted:    31.4K
 * Total Submissions: 83.5K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 
 * 示例 1:
 * 
 * 输入:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 4, 5, 6 ],
 * ⁠[ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * [
 * ⁠ [1, 2, 3, 4],
 * ⁠ [5, 6, 7, 8],
 * ⁠ [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0)
            return ans; // 若数组为空，直接返回答案
        int u = 0; // 赋值上下左右边界
        int d = matrix.length - 1;
        int l = 0;
        int r = matrix[0].length - 1;
        while (true) {
            for (int i = l; i <= r; ++i)
                ans.add(matrix[u][i]); // 向右移动直到最右
            if (++u > d)
                break; // 重新设定上边界，若上边界大于下边界，则遍历遍历完成，下同
            for (int i = u; i <= d; ++i)
                ans.add(matrix[i][r]); // 向下
            if (--r < l)
                break; // 重新设定有边界
            for (int i = r; i >= l; --i)
                ans.add(matrix[d][i]); // 向左
            if (--d < u)
                break; // 重新设定下边界
            for (int i = d; i >= u; --i)
                ans.add(matrix[i][l]); // 向上
            if (++l > r)
                break; // 重新设定左边界
        }
        return ans;

    }
}
// @lc code=end
