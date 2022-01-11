class Solution {
public:
    /* DP - BOTTOM-UP */
    int combinationSum4(vector<int>& nums, int target) {
        vector<int> dp(target+1,0);
        dp[0] = 1;
        sort(nums.begin(), nums.end());
        for (int i=1; i<=target; i++)
            for (int j=0; j<nums.size(); j++) {
                if (nums[j] > i) break;
                dp[i] += dp[i - nums[j]];
            }
        
        return dp.back();
    }
    /* Recursive solution - time limit exceeded */
    int combinationSum3(vector<int>& nums, int target) {
        if (target == 0)
            return 1;
        if (target < 0)
            return 0;
        
        int comb = 0;
        
        for (auto x : nums)
            if (x <= target)
                comb += combinationSum4(nums,target-x);
        
        return comb;
    }
    /* Recursion + memoization - TOP-DOWN*/
    int combinationSum2(vector<int>& nums, int target) {
        vector<int> memo(target+1,-1);
        return helper(nums,target,memo);
    }
    int helper(vector<int>& nums, int target,vector<int>& memo) {
        if (memo[target] != -1)
            return memo[target];
        
        if (target == 0)
            return 1;
        if (target < 0)
            return 0;
        
        int comb = 0;
        
        for (auto x : nums)
            if (x <= target)
                comb += combinationSum4(nums,target-x);
        
        memo[target] = comb;
        return comb;
    }
};