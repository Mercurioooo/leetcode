/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 *
 * https://leetcode-cn.com/problems/decode-ways/description/
 *
 * algorithms
 * Medium (22.11%)
 * Likes:    226
 * Dislikes: 0
 * Total Accepted:    23.5K
 * Total Submissions: 105.6K
 * Testcase Example:  '"12"'
 *
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * 
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * 
 * 示例 1:
 * 
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 
 * 
 * 示例 2:
 * 
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 
 * 
 * 输入: "217"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 
 * 
 */

// @lc code=start
class Solution {
    int length;
    int ans = 0;
    String s;
    boolean flag = false;
    // int[] dynami;

    public int numDecodings(String s) {
        this.s = s;
        length = s.length();
        if (length == 0)
            return 0;
        // dynami = new int[length];
        if (s.charAt(0) == '0')
            return 0;
        // dynami[0] = 1;
        if (length == 1)
            return 1;
        int pre = 1, prepre = 0, cur = 0;
        for (int i = 1; i < length; i++) {
            // dynami[i] = (s.charAt(i) == '0') ? 0 : pre;
            cur = (s.charAt(i) == '0') ? 0 : pre;
            boolean ok = s.charAt(i - 1) != '0' & ((s.charAt(i - 1) - '0') * 10 + s.charAt(i) - '0' <= 26);
            if (ok && i >= 2)
                // dynami[i] += dynami[i - 2];
                cur += prepre;
            else if (ok)
                // dynami[i] += 1;
                cur++;
            prepre = pre;
            pre = cur;

        }
        // dp[i]表示到第i位能表示的个数
        // for (int i : dynami)
        // System.out.println(i);
        return cur;
    }

}
// @lc code=end
