class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length, ans = 0;
        int[][] dp = new int[n+1][amount+1];
        
        for (int i=1; i<=n; i++){
            
            dp[i][0] = 1;
            
            for (int j = 1; j<=amount; j++) {
                
                dp[i][j] = dp[i-1][j] + (j>=coins[i-1]? dp[i][j - coins[i-1]] : 0);
                    
            }
        }
        return dp[n][amount];
    }
}