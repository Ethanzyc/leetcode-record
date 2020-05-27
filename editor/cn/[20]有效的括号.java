//给定一个只包括 "("，")"，"{"，"}"，"["，"]" 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution20 {
    public static boolean isValid(String s) {
        if ("".equals(s)) {
            return true;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        char[] chars = s.toCharArray();
        Character[] container = new Character[chars.length];

        int index = -1;
        for (int i = 0; i < chars.length; i++) {
            if (container[0]==null) {
                container[0] = chars[i];
                index++;
            } else {
                if (map.get(container[index]) == null) {
                    return false;
                }
                if (map.get(container[index]).equals(chars[i])) {
                    container[index] = null;
                    index--;
                } else {
                    container[index+1] = chars[i];
                    index++;
                }
            }
        }
        return container[0] == null;
    }

    public static void main(String[] args) {
        System.out.println(isValid("{[]}"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
