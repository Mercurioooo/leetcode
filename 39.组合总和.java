import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 *
 * https://leetcode-cn.com/problems/combination-sum/description/
 *
 * algorithms
 * Medium (67.40%)
 * Likes:    446
 * Dislikes: 0
 * Total Accepted:    46.6K
 * Total Submissions: 69.1K
 * Testcase Example:  '[2,3,6,7]\n7'
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * candidates 中的数字可以无限制重复被选取。
 * 
 * 说明：
 * 
 * 
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 
 * 
 * 示例 1:
 * 
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * ⁠ [7],
 * ⁠ [2,2,3]
 * ]
 * 
 * 
 * 示例 2:
 * 
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * 
 */

// @lc code=start
class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    private int [] candidates;
    int len;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        len = candidates.length;
        if(len == 0) return ans;
        Arrays.sort(this.candidates);
        combination( target, 0, new Stack<Integer>());
        return ans;
    }

    private void combination( int target, int index, Stack<Integer> stack) {
        if (target == 0) {
            ans.add(new ArrayList<>(stack));
            return;
        }
        for (int i = index; i < len && target - candidates[i] >= 0; i++) {
            stack.add(candidates[i]);
            // 【关键】因为元素可以重复使用，这里递归传递下去的是 i 而不是 i + 1
            combination(target - candidates[i], i, stack);
            stack.pop();
        }
        
    }
}
// @lc code=end
