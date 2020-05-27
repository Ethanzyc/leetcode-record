//实现 pow(x, n) ，即计算 x 的 n 次幂函数。 
//
// 示例 1: 
//
// 输入: 2.00000, 10
//输出: 1024.00000
// 
//
// 示例 2: 
//
// 输入: 2.10000, 3
//输出: 9.26100
// 
//
// 示例 3: 
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25 
//
// 说明: 
//
// 
// -100.0 < x < 100.0 
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。 
// 
// Related Topics 数学 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
class Solution50 {
    public static double myPow(double x, int n) {
        if (n==0) {
            return 1;
        }
        int oriN = n;
        double extra = 1;
        while (true) {
            if (n == 0 || n == -1 || n== 1) {
                break;
            }
            if (n%2 == 0) {
                x=x*x;
                n=n/2;
            } else {
                extra = extra * x;
                x=x*x;
                if (oriN >= 0) {
                    n=(n-1)/2;
                } else {
                    n=(n+1)/2;
                }
            }
        }

        if (oriN >= 0) {
            return x*extra;
        } else {
            return 1/(x*extra);
        }
    }

    public static void main(String[] args) {
        System.out.println(myPow(34.00515, -3));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
