class Solution {
public:
    int rob(vector<int>& nums) {
        int l = nums.size();
        vector<int> dp(l);
        dp[0] = nums[0];
        if(l > 1)
            dp[1] = max(dp[0],nums[1]);
            
        for (int i=2; i < l;i++)
            dp[i] = max(dp[i-1],dp[i-2]+nums[i]);
        
        return dp[nums.size()-1];
    }
};