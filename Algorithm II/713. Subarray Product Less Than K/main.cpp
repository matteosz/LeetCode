class Solution {
public:
    int numSubarrayProductLessThanK(vector<int>& nums, int k) {
        int ans = 0, n = nums.size(), start = 0, end = 0;
        int curr = 1;
        
        if (k <= 1) return 0;
        
        while (end < n){

            curr *= nums[end];
            while (curr >= k) 
                curr /= nums[start++];
        
            ans += end++ - start + 1;
        }
        
        return ans;
    }
};