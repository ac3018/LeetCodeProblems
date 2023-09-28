public class LCS_1140 {
  public static void main(String[] args) {

  }

}

class Solution {
  /**
   * Bottom up tabulation dynamic programming
   * Time: O(n * m)
   * Space: O((n + 1) * (m + 1))
   */
  public int longestCommonSubsequence(String text1, String text2) {
    int len1 = text1.length();
    int len2 = text2.length();
    int[][] dp = new int[len1 + 1][len2 + 1];

    // Can start from end
    for (int i = len1 - 1; i >= 0; i--) {
      for (int j = len2 - 1; j >= 0; j--) {
        if (text1.charAt(i) == text2.charAt(j)) {
          dp[i][j] = 1 + dp[i + 1][j + 1];
        } else {
          dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
        }
      }
    }
    return dp[0][0];

    // Can also start from beginning
    /**
      for (int i = 1; i < len1 + 1; i++) {
        for (int j = 1; j < len2 + 1; j++) {
          if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
            dp[i][j] = 1 + dp[i - 1][j - 1];
          } else {
            dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
          }
        }
      }
      return dp[len1][len2];
    */
  }
}

/**
 *    a  c  e  ""
 * a [3, 2, 1, 0]
 * b [2, 2, 1, 0]
 * c [2, 2, 1, 0]
 * d [1, 1, 1, 0]
 * e [1, 1, 1, 0]
 * ""[0, 0, 0, 0]
 * 
 *    "" a  c  e
 * ""[0, 0, 0, 0]
 * a [0, 1, 1, 1]
 * b [0, 1, 1, 1]
 * c [0, 1, 2, 2]
 * d [0, 1, 2, 2]
 * e [0, 1, 2, 3]
 */