/*
 * @lc app=leetcode.cn id=81 lang=java
 *
 * [81] 搜索旋转排序数组 II
 *
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/description/
 *
 * algorithms
 * Medium (34.50%)
 * Likes:    72
 * Dislikes: 0
 * Total Accepted:    13.4K
 * Total Submissions: 38.7K
 * Testcase Example:  '[2,5,6,0,0,1,2]\n0'
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * 
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * 
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 * 
 * 示例 1:
 * 
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 * 
 * 进阶:
 * 
 * 
 * 这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
 * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean search(int[] nums, int target) {
        int length = nums.length;
        if(length == 0) return false;
        int left = 0,right = length-1;
/*        
1.直接 nums[mid] == target
2.当数组为 [1,2,1,1,1],nums[mid] == nums[left] == nums[right]，需要 left++, right --;
3.当 nums[left]<= nums[mid]，说明是在左半边的递增区域
​ a. nums[left] <=target < nums[mid]，说明 target 在 left 和 mid 之间。我们令 right = mid - 1;
​ b. 不在之间，我们令 left = mid + 1;
4.当 nums[mid] < nums[right]，说明是在右半边的递增区域
​ a. nums[mid] < target <= nums[right]，说明 target 在 mid 和 right 之间，我们令 left = mid + 1
​ b. 不在之间，我们令 right = mid - 1;
*/
        while(left<=right){
            int mid = (left + right)>>1;
            if(nums[mid] == target) return true;
            if(nums[mid] == nums[left] && nums[mid] == nums[right]) { left++;right--;}
            else if(nums[left] <= nums[mid]) {
                if(nums[left] <=target && target < nums[mid]) right = mid -1;
                else left = mid + 1;
            }
            else  {
                if(nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
            
        return false;
    }
}
// @lc code=end

