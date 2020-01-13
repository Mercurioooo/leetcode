import java.util.List;

/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 *
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/description/
 *
 * algorithms
 * Easy (51.06%)
 * Likes:    220
 * Dislikes: 0
 * Total Accepted:    58.9K
 * Total Submissions: 113.9K
 * Testcase Example:  '[2,7,11,15]\n9'
 *
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 
 * 说明:
 * 
 * 
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 
 * 
 * 示例:
 * 
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * 
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;
        int[] ans = new int[2];
        if (length == 0)
            return ans;
        int i = 0, j = length - 1;
        int sum = 0;

        while (i < j && i < length && j > 0) {
            sum = numbers[i] + numbers[j];
            if (sum < target)
                i++;
            else if (sum > target)
                j--;
            else {
                ans[0] = i + 1;
                ans[1] = j + 1;
                return ans;
            }
        }
        return ans;
    }
}
// @lc code=end
