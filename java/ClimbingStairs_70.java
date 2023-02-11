public class ClimbingStairs_70 {
    // Method 1: Dynamic Programming
    public int climbStairs(int n) {
        return helper(n, new int[] {1, 1});
    }
    private int helper(int n, int[] dp) {
        if (n == 1) return dp[0];
        int temp = dp[0];
        dp[0] += dp[1];
        dp[1] = temp;
        return helper(n - 1, dp);
    }
}
