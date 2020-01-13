import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 *
 * https://leetcode-cn.com/problems/subsets/description/
 *
 * algorithms
 * Medium (75.33%)
 * Likes:    395
 * Dislikes: 0
 * Total Accepted:    47.6K
 * Total Submissions: 63K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 
 * 说明：解集不能包含重复的子集。
 * 
 * 示例:
 * 
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * ⁠ [3],
 * 
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 */

// @lc code=start
class Solution {
    List<List<Integer>> ans;
    int length;
    Stack<Integer> stack;
    int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<List<Integer>>();
        List<List<Integer>> temp = new ArrayList<>();
        ans.add(new ArrayList<>());
        for (int i : nums) {
            temp = new ArrayList<List<Integer>>();
            for (List<Integer> list : ans) {
                temp.add(new ArrayList<>(list));
                temp.get(temp.size() - 1).add(i);
            }
            ans.addAll(temp);
        }
        return ans;
    }

}
// @lc code=end
