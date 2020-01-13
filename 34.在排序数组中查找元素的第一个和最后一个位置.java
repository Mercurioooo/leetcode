/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 *
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * algorithms
 * Medium (38.18%)
 * Likes:    251
 * Dislikes: 0
 * Total Accepted:    45.6K
 * Total Submissions: 119.5K
 * Testcase Example:  '[5,7,7,8,8,10]\n8'
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 
 * 示例 1:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 
 * 示例 2:
 * 
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * 
 */

// @lc code=start
class Solution {
    /**nums[0] <= nums[mid]（0 - mid不包含旋转）且nums[0] <= target <= nums[mid] 时 high 向前规约；

    nums[mid] < nums[0]（0 - mid包含旋转），target <= nums[mid] < nums[0] 时向前规约（target 在旋转位置到 mid 之间）

    nums[mid] < nums[0]，nums[mid] < nums[0] <= target 时向前规约（target 在 0 到旋转位置之间）
*/
    public int[] searchRange(int[] nums, int target) {
        int [] ans = new int [2];
        ans[0] = left_bound(nums, target);
        ans[1] = right_bound(nums,target);
        return ans;
    }
    private int left_bound(int [] nums,int target){
        if(nums.length == 0) return -1;
        int l = 0;
        int r = nums.length;
        while(l < r){
            int mid = (l+r)>>1;
            if(nums[mid] == target){
                r = mid;
            }
            else if(nums[mid] < target ){
                l = mid + 1;
            }
            else if(nums[mid] > target){
                r = mid;
            }
        }
        // target 比所有数都大
        if (l == nums.length) return -1;
        // 类似之前算法的处理方式
        return nums[l] == target ? l : -1;
    }
    private int right_bound(int [] nums,int target){
        if(nums.length == 0) return -1;
        int l = 0;
        int r = nums.length;
        while(l < r){
            int mid = (l+r)>>1;
            if(nums[mid] == target){
                l = mid + 1;
            }
            else if(nums[mid] < target ){
                l = mid + 1;
            }
            else if(nums[mid] > target){
                r = mid;
            }
        }
        if (l == 0) return -1;
        return nums[l-1] == target ? (l-1) : -1;
    }

}
// @lc code=end

