import java.util.List;

class Solution {
  /**
   * Use a bottom up DP approach 
   * Time: O(n^2)
   * Space: O(n)
   * Starting from the bottom, we can get the minimum of each level by adding the current value with the minimum of the adjacents on the next level
   */
  public int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();
    
    // We add one here because for the last level, there are no adjacents, so the minimum would be 0
    int[] dp = new int[n + 1];
    
    for(int i = n - 1; i >= 0; i--) {
      for (int j = 0; j < i + 1; j++) {
        // dp[current index] = current value + minimum of the two adjacent values on the next level
        dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
      }
    }

    return dp[0];
  }
}

public class Triangle_120 {
  public static void main(String[] args) {

  }
}
