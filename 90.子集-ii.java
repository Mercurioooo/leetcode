import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 *
 * https://leetcode-cn.com/problems/subsets-ii/description/
 *
 * algorithms
 * Medium (57.60%)
 * Likes:    142
 * Dislikes: 0
 * Total Accepted:    17.1K
 * Total Submissions: 29.5K
 * Testcase Example:  '[1,2,2]'
 *
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 
 * 说明：解集不能包含重复的子集。
 * 
 * 示例:
 * 
 * 输入: [1,2,2]
 * 输出:
 * [
 * ⁠ [2],
 * ⁠ [1],
 * ⁠ [1,2,2],
 * ⁠ [2,2],
 * ⁠ [1,2],
 * ⁠ []
 * ]
 * 
 */

// @lc code=start
class Solution {
    List<List<Integer>> ans;
    int length;
    Stack<Integer> stack;
    int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int flag = 1;
        length = nums.length;
        ans.add(new ArrayList<>());
        if (length == 0)
            return ans;
        for (int i = 0; i < length; i++) {
            List<List<Integer>> temp = new ArrayList<List<Integer>>();
            for (int j = 0; j < ans.size(); j++) {
                if (i > 0 && nums[i] == nums[i - 1] && j < flag) {
                    continue;
                }
                temp.add(new ArrayList<>(ans.get(j)));
                temp.get(temp.size() - 1).add(nums[i]);
            }
            flag = ans.size();
            ans.addAll(temp);

        }

        return ans;
    }

}
// @lc code=end
