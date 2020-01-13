/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 *
 * https://leetcode-cn.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (27.62%)
 * Likes:    1458
 * Dislikes: 0
 * Total Accepted:    139.7K
 * Total Submissions: 505.7K
 * Testcase Example:  '"babad"'
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 
 * 示例 1：
 * 
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 
 * 
 * 示例 2：
 * 
 * 输入: "cbbd"
 * 输出: "bb"
 * 
 * 
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        if(s.equals("")) return "";
        String b = new StringBuffer(s).reverse().toString(); //字符串倒置
        int length = s.length();
        int maxEnd = 0;
        int [][] a = new int[length][length];
        int maxLen = 0;
    
        for(int i = 0 ; i < length ; i++){
            for(int j = 0; j < length ; j++){
                if(s.charAt(i)==b.charAt(j)){
                    if(i == 0||j==0 )  a[i][j] = 1;
                    else a[i][j] = a[i-1][j-1] + 1;
                }
                if (a[i][j] > maxLen) {
                    int beforeRev = length - 1 - j;
                    if (beforeRev + a[i][j] - 1 == i) { //判断下标是否对应
                        maxLen = a[i][j];
                        maxEnd = i;
                    }
                    /*************************************/
                }
            }

        }

        return s.substring(maxEnd-maxLen+1,  maxEnd+1);
    }
    
}
// @lc code=end

