class Solution {
public:
    /* 2-pass solution, O(N) space and time */
    vector<int> productExceptSelf2(vector<int>& nums) {
        int n = nums.size();
        vector<int> ans(n), suf(n,nums[n-1]), pre(n,nums[0]);
        
        for (int i=1; i<n; i++) {
            pre[i] = pre[i-1]*nums[i];
            suf[n-1-i] = suf[n-i]*nums[n-1-i];
        }
        
        for (int i=0; i<n; i++)
            ans[i] = (i>0? pre[i-1] : 1)*(i<n-1? suf[i+1] : 1);
        
        return ans;
    }
    /* Space optimization - use ans to store prefix and on fly suffix */
    vector<int> productExceptSelf(vector<int>& nums) {
        int n = nums.size(), suf = 1;
        vector<int> ans(n,nums[0]);
        
        for (int i=1; i<n; i++) 
            ans[i] = ans[i-1]*nums[i];
        
        for (int i=n-1; i>=0; i--) {
            ans[i] = suf * (i>0? ans[i-1] : 1);
            suf *= nums[i];
        }
        
        return ans;
    }
};