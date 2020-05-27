//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。 
//
// 示例 1: 
//
// 输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
// 
//
// 示例 2: 
//
// 输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
// 
// Related Topics 字符串 动态规划


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution32 {
    public int longestValidParentheses(String s) {
        if ("".equals(s)) {
            return 0;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('(',')');
        char[] chars = s.toCharArray();
        Character[] container = new Character[chars.length];

        int index = -1;
        int length = 0;
        for (int i = 0; i < chars.length; i++) {
            if (container[0]==null) {
                container[0] = chars[i];
                index++;
            } else {
                if (map.get(container[index]) == null) {
                    container = new Character[chars.length];
                    length = 0;
                    index++;
                }
                if (map.get(container[index]).equals(chars[i])) {
                    container[index] = null;
                    length++;
                    index--;
                } else {
                    container[index+1] = chars[i];
                    index++;
                }
            }
        }
        return length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
