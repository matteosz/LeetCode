class Solution {
public:
    int findNumberOfLIS(vector<int>& nums) {
       
        int n = nums.size(), max_len = 0, ans = 0;
        vector<vector<int>> dp(2,vector<int>(n));
        
        for (int i=0; i<n; i++) {
            dp[0][i] = dp[1][i] = 1;
            
            for (int j=i-1; j>=0; j--) 
                if (nums[j] < nums[i] && dp[1][i] <= dp[1][j]+1) {
                    if (dp[1][i] == dp[1][j]+1) 
                        dp[0][i] += dp[0][j];
                    else {
                        dp[1][i] = dp[1][j] + 1;
                        dp[0][i] = dp[0][j];
                    }
                }
            if (dp[1][i] == max_len)
                ans += dp[0][i];
            else if (dp[1][i] > max_len) {
                max_len = dp[1][i];
                ans = dp[0][i];
            }
        }
        
        return ans;
    }
};