class Solution {
    
    int rob_linear(vector<int>& nums,int l,int r) {
        int prev = 0, best = 0;
        for(int i = l; i < r;i++){
            int temp = max(best, prev+nums[i]);
            prev = best;
            best = temp;
        }
        return best;
    }
public:
    int rob(vector<int>& nums) {
        int n = nums.size();
        if (n == 1)
            return nums[0];
        int r1 = rob_linear(nums,0,n-1), r2 = rob_linear(nums,1,n);
        return max(r1,r2);
    }
};