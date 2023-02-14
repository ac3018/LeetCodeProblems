import java.util.Arrays;

public class NumberOfFairPairs_6355 {
//    Input: nums = [0,1,7,4,4,5], lower = 3, upper = 6
//    Output: 6
//    Explanation: There are 6 fair pairs: (0,3), (0,4), (0,5), (1,3), (1,4), and (1,5).

//    Input: nums = [1,7,9,2,5], lower = 11, upper = 11
//    Output: 1 2 5 7 9
//    Explanation: There is a single fair pair: (2,3).
    public long countFairPairs(int[] nums, int lower, int upper) {
        // Sort nums array and use binary search to find the left and right bounds
        // of the numbers that satisfy the conditions for each nums[i]
        long pairs = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int left = leftIndex(nums, lower - nums[i], i + 1);
            int right = rightIndex(nums, upper - nums[i], i + 1);
            pairs += right - left;
        }
        return pairs;
    }

    // Find the index of the number that when added to nums[i] will be greater than or equal to lower
    private int leftIndex(int[] nums, int target, int left) {
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    // Find the index + 1 of the number that when added to nums[i] will be less than or equal to upper
    private int rightIndex(int[] nums, int target, int left) {
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
