public class MergeSortedArray_88 {

}

class Solution {
  /**
   * Time Complexity: O(m + n)
   * Space Complexity: O(1)
   * Use three pointers, one to keep track of current place in nums2, one to keep
   * track of current place in nums1, and one to keep track of current place in
   * overall array
   */
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int n2 = n - 1;
    int n1 = m - 1;
    int c = m + n - 1;

    while (c >= 0) {
      if (n2 >= 0 && n1 >= 0) {
        if (nums2[n2] > nums1[n1]) {
          nums1[c] = nums2[n2];
          n2--;
        } else {
          nums1[c] = nums1[n1];
          n1--;
        }
        c--;
      } else if (n2 < 0) {
        nums1[c] = nums1[n1];
        c--;
        n1--;
      } else {
        nums1[c] = nums2[n2];
        c--;
        n2--;
      }
    }
  }
}