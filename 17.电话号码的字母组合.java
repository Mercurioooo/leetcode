import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 *
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (51.46%)
 * Likes:    496
 * Dislikes: 0
 * Total Accepted:    58.6K
 * Total Submissions: 113.9K
 * Testcase Example:  '"23"'
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * 
 */

// @lc code=start
class Solution {
    private Map<Integer, ArrayList<Character>> map = new HashMap<>();
    private List<String> ans = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return ans;
        // Map<Integer, ArrayList<Character>> map = new HashMap<>();
        map.put(1, new ArrayList<Character>() {
            {
                add('!');
                add('@');
                add('#');
            }
        });

        map.put(2, new ArrayList<Character>() {
            {
                add('a');
                add('b');
                add('c');
            }
        });
        map.put(3, new ArrayList<Character>() {
            {
                add('d');
                add('e');
                add('f');
            }
        });
        map.put(4, new ArrayList<Character>() {
            {
                add('g');
                add('h');
                add('i');
            }
        });
        map.put(5, new ArrayList<Character>() {
            {
                add('j');
                add('k');
                add('l');
            }
        });
        map.put(6, new ArrayList<Character>() {
            {
                add('m');
                add('n');
                add('o');
            }
        });
        map.put(7, new ArrayList<Character>() {
            {
                add('p');
                add('q');
                add('r');
                add('s');
            }
        });
        map.put(8, new ArrayList<Character>() {
            {
                add('t');
                add('u');
                add('v');
            }
        });
        map.put(9, new ArrayList<Character>() {
            {
                add('w');
                add('x');
                add('y');
                add('z');
            }
        });
        int length = digits.length();
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= 9; i++) {
            ArrayList<Character> array = map.get(i);
            for (char c : array) {
                System.out.print(c);
            }
            System.out.println();
        }
        backTrace(digits, sb, 0);

        return ans;
    }

    void backTrace(String digit, StringBuffer sb, int index) {
        if (index == digit.length()) {
            ans.add(sb.toString());
            return;
        }

        int num = digit.charAt(index) - '0';
        ArrayList<Character> array = map.get(num);

        for (int i = 0; i < array.size(); i++) {
            sb.append(array.get(i));
            backTrace(digit, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
// @lc code=end
