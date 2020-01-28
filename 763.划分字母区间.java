import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=763 lang=java
 *
 * [763] 划分字母区间
 *
 * https://leetcode-cn.com/problems/partition-labels/description/
 *
 * algorithms
 * Medium (68.02%)
 * Likes:    84
 * Dislikes: 0
 * Total Accepted:    6.3K
 * Total Submissions: 9.2K
 * Testcase Example:  '"ababcbacadefegdehijhklij"'
 *
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 * 
 * 示例 1:
 * 
 * 输入: S = "ababcbacadefegdehijhklij"
 * 输出: [9,7,8]
 * 解释:
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 * 
 * 
 * 注意:
 * 
 * 
 * S的长度在[1, 500]之间。
 * S只包含小写字母'a'到'z'。
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> partitionLabels(String string) {
        int length = string.length();
        List<Integer> list = new ArrayList<>();
        if (length == 0)
            return list;
        int[] right = new int[26];
        for (int i = 0; i < length; i++) {
            char c = string.charAt(i);
            right[c - 'a'] = Math.max(right[c - 'a'], i);
        }
        for (int i = 0; i < 26; i++) {
            System.out.print(right[i]);
        }
        System.out.println();
        int max = 0;
        int lastIndex = 0;
        for (int i = 0; i < length; i++) {
            while (i < length && right[string.charAt(i) - 'a'] < max) {
                i++;
            }
            max = right[string.charAt(i) - 'a'];
            list.add(lastIndex - max);
            lastIndex = i;
        }
        return list;
    }
}
// @lc code=end
