public class SortArrayByParity_905 {

}

class Solution {
  /**
   * Algorithm: Use two pointers to keep track of the even and odd positions
   * Time Complexity: O(n), since every number is checked once
   * Space Complexity: O(1), sorting in place
   */
  public int[] sortArrayByParity(int[] nums) {
    int i = 0, j = nums.length - 1;

    while (i < j) {
      // if nums[i] is even, then it is in the correct place
      if (nums[i] % 2 == 0)
        i++;
      else {
        // nums[i] is odd, then it must be moved to the next odd position

        // if nums[j] is odd, then it is in the right place
        if (nums[j] % 2 != 0)
          j--;
        else {
          // swap the odd and even numbers
          int temp = nums[i];
          nums[i] = nums[j];
          nums[j] = temp;
        }
      }
    }

    return nums;
  }
}