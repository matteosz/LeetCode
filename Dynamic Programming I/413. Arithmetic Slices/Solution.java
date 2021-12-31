class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0, n = nums.length;
        
        if (n < 3) return ans;
        
        int diff = nums[1] - nums[0], curr = 2, N = 3;
        
        for (int i=2;i<nums.length;i++){
            int delta = nums[i]-nums[i-1];
            if (delta == diff){
                curr++;
                ans += (curr-N) + 1;
            }
            else{
                curr = 2;
                diff = delta;
            }
        }
        return ans;
    }
}