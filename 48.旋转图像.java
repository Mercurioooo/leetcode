/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] 旋转图像
 *
 * https://leetcode-cn.com/problems/rotate-image/description/
 *
 * algorithms
 * Medium (65.50%)
 * Likes:    312
 * Dislikes: 0
 * Total Accepted:    43.4K
 * Total Submissions: 66.3K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 
 * 将图像顺时针旋转 90 度。
 * 
 * 说明：
 * 
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * 
 * 示例 1:
 * 
 * 给定 matrix = 
 * [
 * ⁠ [1,2,3],               
 * ⁠ [4,5,6],
 * ⁠ [7,8,9]
 * ],
 * 
 * 00 20    01 21   02 22
 * 10 01    11 11   12 21
 * 20 00    21 10   22 20
 * 原地旋转输入矩阵，使其变为:
 * [
 * ⁠ [7,4,1],
 * ⁠ [8,5,2],
 * ⁠ [9,6,3]
 * ]
 * 
 * 
 * 示例 2:
 * 
 * 给定 matrix =
 * [
 * ⁠ [ 5, 1, 9,11],
 * ⁠ [ 2, 4, 8,10],
 * ⁠ [13, 3, 6, 7],
 * ⁠ [15,14,12,16]
 * ], 
 * 
 * 原地旋转输入矩阵，使其变为:
 * [
 * ⁠ [15,13, 2, 5],
 * ⁠ [14, 3, 4, 1],
 * ⁠ [12, 6, 8, 9],
 * ⁠ [16, 7,10,11]
 * ]
 * 
 * 00 03
 * 01 13
 * 02 23
 * 03 33
 * 
 * 10 02
 * 11 12
 * 12 22
 * 13 32
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
      int n = matrix.length;
  
      // transpose matrix
      for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
          int tmp = matrix[j][i];
          matrix[j][i] = matrix[i][j];
          matrix[i][j] = tmp;
        }
      }
    //   for (int i = 0; i < n; i++) {
    //     for (int j = 0; j < n; j++) {
    //         System.out.print(matrix[i][j]);
    //     }
    //     System.out.println();
    //   }
      // reverse each row
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n / 2; j++) {
          int tmp = matrix[i][j];
          matrix[i][j] = matrix[i][n - j - 1];
          matrix[i][n - j - 1] = tmp;
        }
      }
    //   for (int i = 0; i < n; i++) {
    //     for (int j = 0; j < n; j++) {
    //         System.out.print(matrix[i][j]);
    //     }
    //     System.out.println();
    //   }
    }
  }
// @lc code=end

