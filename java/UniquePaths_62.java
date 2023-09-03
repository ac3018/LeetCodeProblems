public class UniquePaths_62 {

}

class Solution {
  /**
   * Bottom up tabulation dynamic programming
   * Time: O(n * m)
   * Space O(n * m)
   */
  public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    // Initialize first row to 1 because there is only one way
    for (int i = 0; i < n; i++) {
      dp[0][i] = 1;
    }
    // Same for first column
    for (int i = 0; i < m; i++) {
      dp[i][0] = 1;
    }
    // Build the sub problems
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
      }
    }
    return dp[m - 1][n - 1];
  }
}