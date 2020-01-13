import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 *
 * https://leetcode-cn.com/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (42.06%)
 * Likes:    293
 * Dislikes: 0
 * Total Accepted:    56.1K
 * Total Submissions: 133.3K
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target
 * 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * 
 * 
 */

// @lc code=start
class Solution {
  public int threeSumClosest(int[] nums, int target) {
    int len = nums.length;
    if (nums == null || len < 3)
      return 0;
    int  ans = nums[0]+nums[1]+nums[2];
    Arrays.sort(nums); // 排序
    for (int i = 0; i < len; i++) {
      if (i > 0 && nums[i] == nums[i - 1])
        continue; // !!!去重
      int L = i + 1;
      int R = len - 1;
      while (L < R) {
        //System.out.println(nums[i] + " " + nums[L] + " " + nums[R]);
        int sum = nums[i] + nums[L] + nums[R];
        if (sum == target)
          return target;
        if (Math.abs(sum - target) < Math.abs(ans - target)) 
            ans = sum;
        // while (L < R && nums[L] == nums[L + 1])
        //     L++; // 去重!!!
          while (L < R && nums[R] == nums[R - 1])
            R--; // 去重!!!
        if (sum < target)
          L++;
        else if (sum > target)
          R--;
        else return ans;
      }
    }
    return ans;

  }
}
// @lc code=end