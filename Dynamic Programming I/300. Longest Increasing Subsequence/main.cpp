class Solution {
public:
    /* Classical O(N^2) algorithm */
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size(), ans = 1;
        vector<vector<int>> dp(2,vector<int>(n,-1));

        for (int i=0; i<n; i++){
            dp[0][i] = i;
            dp[1][i] = 1;

            int j = i-1;
            while (j >= 0){
                if (nums[j] < nums[i] && dp[1][j]+1 > dp[1][i]){
                    dp[0][i] = j;
                    dp[1][i] = dp[1][j]+1;
                }
                j--;
            }
            ans = max(ans, dp[1][i]);
        }
        return ans;
    }
    /* Improvement - O(NlogN) solution */
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size();
        vector<int> dp;

        for (int x : nums){
            if (dp.empty() || dp[dp.size()-1] < x)//if the current element can be added to the subsequence
                dp.push_back(x);
            else {//substitute the lowest value close to x of the substring with x
                auto i = lower_bound(dp.begin(), dp.end(), x);//binary search
                *i = x;
            }
        }
        return dp.size();
    }
};
