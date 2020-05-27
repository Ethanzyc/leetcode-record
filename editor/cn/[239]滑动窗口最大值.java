//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 
//
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 进阶： 
//
// 你能在线性时间复杂度内解决此题吗？ 
//
// 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution239 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] container = new int[nums.length - k + 1];
        int[] shortNums = new int[k];
        boolean isHead = false;
        int biggestPos = 0;

        for (int i = 0; i < nums.length - k + 1; i++) {
            if (!isHead && i != 0) {
                if (nums[i + k - 1] > nums[biggestPos]) {
                    biggestPos = i + k - 1;
                    container[i] = nums[biggestPos];
                    isHead = false;
                    continue;
                } else {
                    container[i] = nums[biggestPos];
                    if (biggestPos == i) {
                        isHead = true;
                    }
                    continue;
                }
            }
            for (int j = 0; j < k; j++) {
                shortNums[j] = nums[i+j];
            }
            biggestPos = findBiggestPos(shortNums) + i;
            container[i] = nums[biggestPos];
            if (biggestPos == i) {
                isHead = true;
            }
        }
        return container;
    }

    private static int findBiggestPos(int[] nums) {
        int maxPos = -1;
        int maxNum = -100000;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxNum) {
                maxNum = nums[i];
                maxPos = i;
            }
        }
        return maxPos;
    }

    public static void main(String[] args) {
        int[] nums = {-7,-8,7,5,7,1,6,0};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 4)));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
