class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int m = matrix.size(), n = matrix[0].size();
        int ans = 0;
        vector<vector<int>> dp(m+1,vector<int>(n+1));
        for (int i=1; i<=m; i++)
            for (int j=1; j<=n; j++)
                if (matrix[i-1][j-1] == '1'){
                    dp[i][j] = min(dp[i][j-1],min(dp[i-1][j],dp[i-1][j-1])) + 1;
                    ans = max(ans, dp[i][j]);
                }
        
        return ans*ans;
    }
};