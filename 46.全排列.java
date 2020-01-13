import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 *
 * https://leetcode-cn.com/problems/permutations/description/
 *
 * algorithms
 * Medium (72.70%)
 * Likes:    449
 * Dislikes: 0
 * Total Accepted:    59.1K
 * Total Submissions: 81.3K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,2,3]
 * 输出:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 */

// @lc code=start
class Solution {
    private List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0) return ans;
        List<Integer> list = new ArrayList<Integer>();
        for(int i : nums) list.add(i);
        backTrack(nums,0,list);
        return ans;
    }
    private void backTrack(int [] nums,int i,List<Integer> list){
        if(i == nums.length - 1) {
            ans.add(new ArrayList<>(list));
        }
        int length = nums.length;
        for(int j = i; j < length; j++){
            Collections.swap(list, i, j);
            backTrack(nums,i+1,list);
            Collections.swap(list, i, j);
        }
    }

}
// @lc code=end

