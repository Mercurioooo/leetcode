import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int i = 0, j = 0;
        int ans = 0;
        Set<Character> set = new HashSet<Character>();
        while(i<length&&j<length){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                ans = Math.max(ans, j-i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
// @lc code=end

