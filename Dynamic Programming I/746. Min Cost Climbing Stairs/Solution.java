class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length + 1;
        int[] dp = new int[n];// best cost to reach that index
        dp[0] = 0;
        dp[1] = 0;/* I can start either from index 0 or 1 */
        for (int i=2; i<n;i++)
            dp[i] = Math.min(dp[i-2]+cost[i-2],dp[i-1]+cost[i-1]);
        return dp[n-1];
    }
}