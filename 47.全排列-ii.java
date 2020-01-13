import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 *
 * https://leetcode-cn.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (55.49%)
 * Likes:    182
 * Dislikes: 0
 * Total Accepted:    28.9K
 * Total Submissions: 52K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,1,2]
 * 输出:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 * 
 */

// @lc code=start
class Solution {
    private List<List<Integer>> ans = new ArrayList<List<Integer>>();
    private int [] flag;
    public List<List<Integer>> permuteUnique(int[] nums) {
        int length = nums.length;
        if(length == 0) return ans;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i : nums) list.add(i);
        Collections.sort(list);
        flag = new int[length];
        Arrays.fill(flag,0);
        backTrack(nums.length,0,list);
        Set<String> set = new HashSet<String>();
        // for(List<Integer> l : ans){
        //     set.add(l.toString());
        // }
        // for(String l : set) System.out.println(l);
        return ans;
    }
    void backTrack(int length,int i,ArrayList<Integer> list){
        Arrays.fill(flag,i ,length-1, 0);
        if(i == length - 1) {
            ans.add(new ArrayList<Integer>(list) );
            //System.out.println(list);
            return;
        }
        for(int j = i;j < length;j++){
            if(flag[j]==1) continue;
            Collections.swap(list, i, j);
            backTrack(length,i+1,list);
            Collections.swap(list, i, j);
            for(int k = j + 1; k < length; k++){
                if(list.get(k) == list.get(j)) flag[k] = 1;
            }
        }

    }
}
// @lc code=end

        // for (int j = i; j < nums.length; j++) {
        //     boolean isDuplicated = false;
        //     for (int k = i; k<j; k++) {
        //         if (nums[j] == nums[i]) {
        //             isDuplicated = true;
        //             break;
        //         }
        //     }
        //     if (isDuplicated) continue;
        //     Collections.swap(nums, first, i);
        //     permute(n, res, nums, first+1);
        //     Collections.swap(nums, first, i);
        // }
        //3 1 2 1
        //3 1 1 2
        //    
        //3 2 1 1
        //   3 2 1 1    
        //3 1 2 1