//给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值
// 至多为 k。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,2,3,1], k = 3
//输出: true 
//
// 示例 2: 
//
// 输入: nums = [1,0,1,1], k = 1
//输出: true 
//
// 示例 3: 
//
// 输入: nums = [1,2,3,1,2,3], k = 2
//输出: false 
// Related Topics 数组 哈希表 
// 👍 182 👎 0


import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution219 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        k++;
        if (!containsDuplicate(nums)) {
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
            boolean containsDuplicate = containsDuplicate(temp);
            if (containsDuplicate) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() != nums.length;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(containsNearbyDuplicate(nums, 3));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
