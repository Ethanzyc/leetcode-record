//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
class Solution69 {
    public static int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        int i = x;
        if (x > 46340) {
            i = 46340;
        }
        int res = 1;
        int[] con = new int[]{0,i};
        while (res != 0) {

            if (res == 1) {
                i = (i+con[0])/2;
            } else {
                i = (int) Math.ceil((i+con[1])/2.0);
            }
            res = isBetween(x,i,con);
        }
        return i;
    }

    public static int isBetween(int x, int i,int[] con) {
        System.out.println("x:" + x + ",i:" + i);
        long i1 = i * i;
        long i2 = (i + 1L) * (i + 1L);
        if (i1 <= x && i2 > x) {
            return 0;
        }
        if (i1 > x) {
            con[1] = i;
            return 1;
        }
        con[0] = i+1;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395600));
        System.out.println(Math.sqrt(2147395600));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
