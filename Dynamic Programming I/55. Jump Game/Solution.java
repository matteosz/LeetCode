class Solution {
    public boolean canJump(int[] nums) {
        int curr=0;
        for (int i=0;i<nums.length && i <= curr;i++) {
            curr = Math.max(i+nums[i],curr);
            if (curr >= nums.length - 1)
                return true;
        }
        
        return false;
    }
}