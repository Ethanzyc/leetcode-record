//编写一个程序判断给定的数是否为丑数。 
//
// 丑数就是只包含质因数 2, 3, 5 的正整数。 
//
// 示例 1: 
//
// 输入: 6
//输出: true
//解释: 6 = 2 × 3 
//
// 示例 2: 
//
// 输入: 8
//输出: true
//解释: 8 = 2 × 2 × 2
// 
//
// 示例 3: 
//
// 输入: 14
//输出: false 
//解释: 14 不是丑数，因为它包含了另外一个质因数 7。 
//
// 说明： 
//
// 
// 1 是丑数。 
// 输入不会超过 32 位有符号整数的范围: [−231, 231 − 1]。 
// 
// Related Topics 数学 
// 👍 136 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution263 {
    public static boolean isUgly(int num) {
        while (true) {
            int orign = num;
            int remain1 = num % 2;
            if (remain1 == 0) {
                num = num/2;
            }
            int remain2 = num % 3;
            if (remain2 == 0) {
                num = num/3;
            }
            int remain3 = num % 5;
            if (remain3 == 0) {
                num = num/5;
            }

            if (num == 1) {
                return true;
            }
            if (num == orign) {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(isUgly(6));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
