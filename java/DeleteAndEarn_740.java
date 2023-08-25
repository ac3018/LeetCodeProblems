public class DeleteAndEarn_740 {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.deleteAndEarn(new int[] { 2, 2, 3, 3, 3, 4 }));
  }
}

class Solution {
  public int deleteAndEarn(int[] nums) {
    int n = 10001; // largest length of nums
    int[] values = new int[n];

    // bucket sort
    for (int num : nums)
      values[num] += num;

    // best is the max earned, skip is the max of the current + i - 1 value
    int best = 0, skip = 0;
    for (int v : values) {
      int temp = Math.max(skip + v, best);
      skip = best;
      best = temp;
    }
    return best;
  }
}
