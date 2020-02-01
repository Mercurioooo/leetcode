/*
 * @lc app=leetcode.cn id=540 lang=java
 *
 * [540] 有序数组中的单一元素
 *
 * https://leetcode-cn.com/problems/single-element-in-a-sorted-array/description/
 *
 * algorithms
 * Medium (60.78%)
 * Likes:    70
 * Dislikes: 0
 * Total Accepted:    6.2K
 * Total Submissions: 10.2K
 * Testcase Example:  '[1,1,2,3,3,4,4,8,8]'
 *
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 * 
 * 示例 1:
 * 
 * 
 * 输入: [1,1,2,3,3,4,4,8,8]
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: [3,3,7,7,10,11,11]
 * 输出: 10
 * 
 * 
 * 注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。
 * 
 * 输入: [3,3,7,7,10,10,11]
 * 输出: 10
 */

// @lc code=start
class Solution {
    public int singleNonDuplicate(int[] nums) {
        // int length = nums.length;// 一定是奇数
        int l = 0, r = nums.length - 1;// 两个一开始都是偶数
        int m;
        while (l < r) {// 结束条件为l==r
            m = l + (r - l) / 2;
            if (nums[m] == nums[m + 1]) {
                // 左边的个数就是m
                if (m % 2 == 1)// 左边的个数是奇数
                    r = m - 1;
                else
                    l = m + 2;
            } else if (nums[m] == nums[m - 1]) {
                // 左边的个数为m-1
                if ((m - 1) % 2 == 1)
                    r = m - 2;
                else
                    l = m + 1;
            } else {
                return nums[m];
            }
        }
        return nums[l];
    }
}
// @lc code=end
