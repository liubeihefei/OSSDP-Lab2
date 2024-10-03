import java.util.Arrays;

/**
 * @description:
 *
 * 给你一个整数数组 nums 和一个整数 target 。
 *
 * 请你统计并返回 nums 中能满足其最小元素与最大元素的 和 小于或等于 target 的 非空 子序列的数目。
 *
 * 由于答案可能很大，请将结果对 109 + 7 取余后返回。
 *
 *
 *
 * 示例 1：
 *-
 * 输入：nums = [3,5,6,7], target = 9
 * 输出：4
 * 解释：有 4 个子序列满足该条件。
 * [3] -> 最小元素 + 最大元素 <= target (3 + 3 <= 9)
 * [3,5] -> (3 + 5 <= 9)
 * [3,5,6] -> (3 + 6 <= 9)
 * [3,6] -> (3 + 6 <= 9)
 * 示例 2：
 *
 * 输入：nums = [3,3,6,8], target = 10
 * 输出：6
 * 解释：有 6 个子序列满足该条件。（nums 中可以有重复数字）
 * [3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6]
 * 示例 3：
 *
 * 输入：nums = [2,3,3,4,6,7], target = 12
 * 输出：61
 * 解释：共有 63 个非空子序列，其中 2 个不满足条件（[6,7], [7]）
 * 有效序列总数为（63 - 2 = 61）
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 106
 * 1 <= target <= 106
 *
 */
class Solution5 {
    static final int P = 1000000007;
//    static final int MAX_N = 100005;

//    int[] f = new int[MAX_N];

    public int numSubseq(int[] nums, int target) {
//        pretreatment();

        Arrays.sort(nums);

        int ans = 0;
        for (int i = 0; i <= nums.length-1 && nums[i] * 2 <= target; ++i) {
            int maxValue = target - nums[i];
            int pos = binarySearch(nums, maxValue);
//            System.out.println(pos);
            int contribute = (pos >= i) ? (int) Math.pow(2, pos - i) : 0;
//            System.out.println(contribute);
            ans = (ans + contribute) % P;
        }

        return ans;
    }

//    //预处理，不是哥们这啥啊，0位必然是0，整个数组全是0
//    public void pretreatment() {
//        f[0] = 0;
//        for (int i = 1; i < MAX_N; ++i) {
//            f[i] = (f[i - 1] << 1) % P;
//        }
//    }

    //二分查找target在数组中的位置，若找不到则返回目标应该在数组最大的位置
    public int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            //获得中位数
            int mid = (high - low) / 2 + low;
            //找到应该在的位置了，退出
            if(mid == high)
                if(nums[high] > target)
                    return high - 1;
                else
                    return high;
            int num = nums[mid];
            //如果中位数小于等于目标，low移到中间位置右边
            if (num <= target) {
                low = mid + 1;
            } else {//若中位数大于目标，high移到中间位置
                high = mid;
            }
        }
        return low;
    }
}