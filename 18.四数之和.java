import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 *
 * https://leetcode-cn.com/problems/4sum/description/
 *
 * algorithms
 * Medium (35.97%)
 * Likes:    327
 * Dislikes: 0
 * Total Accepted:    41.3K
 * Total Submissions: 114.9K
 * Testcase Example:  '[1,0,-1,0,-2,2]\n0'
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c
 * + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 
 * 注意：
 * 
 * 答案中不可以包含重复的四元组。
 * 
 * 示例：
 * 
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 
 * 满足要求的四元组集合为：
 * [
 * ⁠ [-1,  0, 0, 1],
 * ⁠ [-2, -1, 1, 2],
 * ⁠ [-2,  0, 0, 2]
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int len = nums.length;
        if (nums == null || len < 4)
            return ans;
        if (len == 4 && nums[0] + nums[1] + nums[2] + nums[3] == target) {
            ans.add(Arrays.asList(nums[0], nums[1], nums[2], nums[3]));
            return ans;
        }
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue; // !!!去重
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue; // !!!去重
                int L = j + 1;
                int R = len - 1;
                while (L < R) {
                    // System.out.println(nums[i] + " " + nums[L] + " " + nums[R]);
                    int sum = nums[i] + nums[j] + nums[L] + nums[R];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[L], nums[R]));
                        // 只有确定相等的情况才需要去重.虽然我也不知道为什么
                        while (L < R && nums[L] == nums[L + 1])
                            L++; // 去重!!!
                        while (L < R && nums[R] == nums[R - 1])
                            R--; // 去重!!!
                        L++;
                        R--;

                    }
                    if (sum < target)
                        L++;
                    else if (sum > target)
                        R--;
                }
            }

        }
        return ans;
    }
}
// @lc code=end
