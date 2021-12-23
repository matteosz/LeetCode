class Solution {/* O(n) solution */
    public int[] sortedSquares(int[] nums) {
        int i=0;
        for(;i<nums.length;i++)
            if (nums[i] >= 0)
                break;
        
        // i represents the first non negative number
        int[] res = new int[nums.length];
        int j=i,k=i-1;
        
        for(int c=0;c<nums.length;c++){
            if (k < 0)
                res[c] = nums[j++];
            else if (j >= nums.length)
                res[c] = nums[k--];
            else if (nums[j] <= (-1)*nums[k])
                res[c] = nums[j++];
            else res[c] = nums[k--];
        }
        
        for(i=0;i<nums.length;i++)
            res[i] *= res[i];
        return res;
    }
}