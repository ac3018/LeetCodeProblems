public class MinCostClimbingStairs_746 {
    public int minCostClimbingStairs(int[] cost) {
        /**
         * Test case(s):
         *  Test 1:
         *      Input: cost = [10, 15, 20]
         *      Output: 15
         */
        int first = cost[0];
        int second = cost[1];
        for(int i = 2; i < cost.length; i++) {
            int curCost = cost[i] + Math.min(first, second);
            first = second;
            second = curCost;
        }
        return Math.min(first, second);
    }
}
