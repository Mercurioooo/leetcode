import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 *
 * https://leetcode-cn.com/problems/combination-sum-ii/description/
 *
 * algorithms
 * Medium (58.27%)
 * Likes:    169
 * Dislikes: 0
 * Total Accepted:    29.8K
 * Total Submissions: 51K
 * Testcase Example:  '[10,1,2,7,6,1,5]\n8'
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 
 * 说明：
 * 
 * 
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 
 * 
 * 示例 1:
 * 
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * ⁠ [1, 7],
 * ⁠ [1, 2, 5],
 * ⁠ [2, 6],
 * ⁠ [1, 1, 6]
 * ]
 * 
 * 
 * 示例 2:
 * 
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 * [1,2,2],
 * [5]
 * ]
 * 
 */

// @lc code=start
class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    int [] candidates;
    int len;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
        this.len = candidates.length;
        if(len == 0) return ans;
        Arrays.sort(this.candidates);
        combination(0,target,new Stack<>());
        return ans;
    }
    //[1,1,2,5,6,7,10]
    private void combination(int index,int rest,Stack<Integer> stack){
       // for(int i : stack) System.out.print(i);
        //System.out.println();
        if(rest == 0) {
            ans.add(new ArrayList<>(stack));
            return;
        }
        
        for(int i = index; i < len && rest - candidates[i] >= 0;i++){
            if(i > index && candidates[i] == candidates[i-1]) continue; 
            stack.add(candidates[i]);
            combination(i+1,rest-candidates[i],stack);
            stack.pop();
        }
    }
}
// @lc code=end

