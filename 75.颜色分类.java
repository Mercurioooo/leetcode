import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 *
 * https://leetcode-cn.com/problems/sort-colors/description/
 *
 * algorithms
 * Medium (53.80%)
 * Likes:    272
 * Dislikes: 0
 * Total Accepted:    45.6K
 * Total Submissions: 84.5K
 * Testcase Example:  '[2,0,2,1,1,0]'
 *
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * 
 * 示例:
 * 
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 
 * 进阶：
 * 
 * 
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * 
 * 
 */

// @lc code=start

class Solution {
    /*
     * 荷兰三色旗问题解
     */
    int nums[];

    public void sortColors(int[] array) {
        this.nums = array;
        // 对于所有 idx < i : nums[idx < i] = 0
        // j是当前考虑元素的下标
        int head = 0, curr = 0;
        // 对于所有 idx > k : nums[idx > k] = 2
        int tail = nums.length - 1;
        // [2,0,1]
        while (curr <= tail) {
            if (nums[curr] == 0) {
                // 交换第 p0个和第curr个元素
                // i++，j++
                swap(head, curr);
                head++;
                curr++;
            } else if (nums[curr] == 2) {
                swap(curr, tail);
                tail--;
            } else
                curr++;
        }
    }

    private void swap(int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}

// @lc code=end
