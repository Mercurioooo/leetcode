import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 *
 * https://leetcode-cn.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (72.45%)
 * Likes:    620
 * Dislikes: 0
 * Total Accepted:    54.5K
 * Total Submissions: 75.3K
 * Testcase Example:  '3'
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 
 * 例如，给出 n = 3，生成结果为：
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
        ArrayList<String> list0 = new ArrayList<String>();
        list0.add("");
        ans.add(list0);
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("()");
        ans.add(list1);
        // "(" + 【i=p时所有括号的排列组合】 + ")" + 【i=q时所有括号的排列组合】
        // 其中 p + q = n-1，且 p q 均为非负整数。
        // 事实上，当上述 p 从 0 取到 n-1，q 从 n-1 取到 0 后，所有情况就遍历完了。
        for (int i = 2; i <= n; i++) {
            ArrayList<String> temp = new ArrayList<String>();
            for (int p = 0; p < i; p++) {
                int q = i - 1 - p;
                System.out.println("p=" + p + " q=" + q);
                for (String sp : ans.get(p)) {
                    for (String sq : ans.get(q)) {
                        String s = "(" + sp + ")" + sq;
                        temp.add(s);
                        System.out.println(s);
                    }
                    System.out.println("------------------");
                }
            }
            // for (String s : temp)
            // System.out.println(s);
            // System.out.println("------------------");
            ans.add(temp);
        }
        for (ArrayList<String> a : ans) {
            for (String b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
        return ans.get(n);
    }
}
// @lc code=end
