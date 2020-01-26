import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 *
 * https://leetcode-cn.com/problems/top-k-frequent-elements/description/
 *
 * algorithms
 * Medium (59.01%)
 * Likes:    231
 * Dislikes: 0
 * Total Accepted:    32.9K
 * Total Submissions: 55.1K
 * Testcase Example:  '[1,1,1,2,2,3]\n2'
 *
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 
 * 示例 1:
 * 
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 
 * 说明：
 * 
 * 
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int number = nums.length;// 数字个数,
        // 这里的+1是因为比如一个大小为5的数组全是1,1出现了五次,要把1放在下标为5的地方,所以要开大小为6的数组
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int key : map.keySet()) {
            int times = map.get(key);
            if (buckets[times] == null) {
                buckets[times] = new ArrayList<>();
            }
            buckets[times].add(key);
        }
        List<Integer> top = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && top.size() < k; i--) {
            if (buckets[i] == null)
                continue;
            if (buckets[i].size() <= k)
                top.addAll(buckets[i]);
            else {
                top.addAll(buckets[i].subList(0, k - top.size()));
            }
        }
        return top;
    }
}
// @lc code=end
