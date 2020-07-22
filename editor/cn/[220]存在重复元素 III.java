//在整数数组 nums 中，是否存在两个下标 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值小于等于 t ，且满足 i 和 j 的差的
//绝对值也小于等于 ķ 。 
//
// 如果存在则返回 true，不存在返回 false。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,2,3,1], k = 3, t = 0
//输出: true 
//
// 示例 2: 
//
// 输入: nums = [1,0,1,1], k = 1, t = 2
//输出: true 
//
// 示例 3: 
//
// 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
//输出: false 
// Related Topics 排序 Ordered Map 
// 👍 197 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution220 {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        k++;
        if (!containsDuplicate(nums, t)) {
            return false;
        }
        if (k >= nums.length) {
            return true;
        }
        for (int i = 0; i < nums.length - k + 1; i++) {
            int[] temp = new int[k];
            for (int j = 0; j < k; j++) {
                temp[j] = nums[i+j];
            }
            boolean containsDuplicate = containsDuplicate(temp, t);
            if (containsDuplicate) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicate(int[] nums, int t) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            int tt = nums[i + 1] - nums[i];
            min = Math.min(min, tt);
        }
        return min <= t;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,9,1,5,9};
        System.out.println(containsNearbyAlmostDuplicate(nums, 2, 3));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
